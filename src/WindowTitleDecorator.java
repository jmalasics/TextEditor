import Interface.IWindow;
import Interface.IWindowDecorator;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

/**
 * Created by jmalasics on 1/24/14.
 */
public class WindowTitleDecorator implements IWindowDecorator {

    public static final int TITLE_HEIGHT = 50;

    private IWindow window;

    public WindowTitleDecorator(IWindow window) {
        this.window = window;
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        desktopGraphics.fillRectangle(new Point(Window.WINDOW_BUFFER - TITLE_HEIGHT, Window.WINDOW_BUFFER), new Point(Window.WINDOW_BUFFER, Window.WINDOW_BUFFER + Window.WINDOW_WIDTH), DesktopColor.DARK_GRAY);
        window.paint(desktopGraphics);
    }

}
