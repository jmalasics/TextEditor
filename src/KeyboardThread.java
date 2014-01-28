import Interface.IObserver;
import Interface.ISubject;
import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.IPaintable;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by jmalasics on 1/15/14.
 */
public class KeyboardThread implements ISubject {

    private ArrayList<IObserver> observers;
    private Desktop desktop;
    private int keyCode;

    public KeyboardThread(Desktop desktop) {
        observers = new ArrayList<IObserver>();
        this.desktop = desktop;
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observers) {
            observer.update(keyCode);
            System.out.println("Updating Observer \n Key Code: " + keyCode);
            observer.setCurrentX();
        }

    }

    public void run() {
        while(true) {
            if(desktop.hasKeysQueued()) {
                keyCode = desktop.getKeyCode();
                notifyObservers();
                System.out.println("Repainting Desktop...");
                desktop.repaint();
            }
        }
    }
}
