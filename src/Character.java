import edu.neumont.csc415.*;

/**
 * Created by jmalasics on 1/22/14.
 */
public class Character implements IPaintable {

    private char character;
    private int XLocation;
    private int YLocation;

    public Character(char character, int currentX, int currentY) {
        this.character = character;
        XLocation = currentX;
        YLocation = currentY;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        desktopGraphics.drawChar(character, new Point(XLocation + Window.WINDOW_BUFFER, YLocation + Window.WINDOW_BUFFER), DesktopColor.WHITE);
    }
}
