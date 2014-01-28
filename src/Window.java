import Interface.IObserver;
import edu.neumont.csc415.*;

import java.util.ArrayList;

/**
 * Created by jmalasics on 1/15/14.
 */
public class Window implements IPaintable, IObserver {

    public static final int WINDOW_LENGTH = 500;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_BUFFER = 100;
    public static final int X_BUFFER = 30;
    public static final int Y_BUFFER = 30;

    private Desktop desktop;
    private int currentX;
    private int currentY;
    private ArrayList<Character> characters;
    private int keyCode;

    public Window(Desktop desktop) {
        this.desktop = desktop;
        characters = new ArrayList<Character>();
        currentX = X_BUFFER;
        currentY = Y_BUFFER;
    }

    public void resetCharacters() {
        for(Character character : characters) {
            desktop.unregisterPaintable(character);
        }
        characters = new ArrayList<Character>();
    }

    @Override
    public void update(int keyCode) {
        this.keyCode = keyCode;
        Character character = new Character(getCharacter(keyCode), currentX, currentY);
        desktop.registerPaintable(character);
        characters.add(character);
    }

    public char getCharacter(int keyCode) {
        return (char) keyCode;
    }

    @Override
    public int getCurrentX() {
        return currentX;
    }

    @Override
    public void setCurrentX() {
        currentX += desktop.getCharWidth((char) keyCode);
        if(currentX >= WINDOW_WIDTH - X_BUFFER) {
            currentX = X_BUFFER;
            setCurrentY();
        }
    }

    @Override
    public int getCurrentY() {
        return currentY;
    }

    @Override
    public void setCurrentY() {
        currentY += desktop.getCharHeight() + Y_BUFFER;
        if(currentY >= WINDOW_LENGTH - Y_BUFFER) {
            currentY = Y_BUFFER;
            resetCharacters();
        }
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        desktopGraphics.fillRectangle(new Point(WINDOW_BUFFER, WINDOW_BUFFER), new Point(WINDOW_LENGTH + WINDOW_BUFFER, WINDOW_WIDTH + WINDOW_BUFFER), DesktopColor.BLACK);
    }

}
