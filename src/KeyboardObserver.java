import Interface.IObserver;
import edu.neumont.csc415.Desktop;
import java.lang.*;
import java.util.ArrayList;

/**
 * Created by jmalasics on 1/15/14.
 */
public class KeyboardObserver implements IObserver {

    private Desktop desktop;
    private ArrayList<Character> characters;

    private int currentX;
    private int currentY;
    private int keyCode;

    public KeyboardObserver(Desktop desktop) {
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
        if(currentX >= Window.WINDOW_WIDTH - X_BUFFER) {
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
        if(currentY >= Window.WINDOW_LENGTH - Y_BUFFER) {
            currentY = Y_BUFFER;
            resetCharacters();
        }
    }

}
