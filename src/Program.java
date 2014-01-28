import edu.neumont.csc415.Desktop;

/**
 * Created by jmalasics on 1/15/14.
 */
public class Program {

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }

    private Desktop desktop;
    private Window window;

    public Program() {
        desktop = new Desktop(1000,1000);
        addWindow();
    }

    public void addWindow() {
        window = new Window(desktop);
        desktop.registerPaintable(window);
        desktop.repaint();
    }

    public void run() {
        KeyboardThread keyboardThread = new KeyboardThread(desktop);
        keyboardThread.registerObserver(window);
        keyboardThread.run();
    }

}
