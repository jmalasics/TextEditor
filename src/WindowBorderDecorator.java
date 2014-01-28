import Interface.IWindow;
import Interface.IWindowDecorator;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

/**
 * Created by jmalasics on 1/24/14.
 */
public class WindowBorderDecorator implements IWindowDecorator {

    public static final int BORDER_SIZE = 5;

    private IWindow window;

    public WindowBorderDecorator(IWindow window) {
        this.window = window;
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        desktopGraphics.fillRectangle(new Point(Window.WINDOW_BUFFER - BORDER_SIZE, Window.WINDOW_BUFFER - BORDER_SIZE), new Point(Window.WINDOW_BUFFER + Window.WINDOW_WIDTH + BORDER_SIZE, Window.WINDOW_BUFFER + Window.WINDOW_LENGTH + BORDER_SIZE), DesktopColor.BLUE);
        window.paint(desktopGraphics);
    }

}
