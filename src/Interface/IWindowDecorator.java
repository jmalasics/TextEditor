package Interface;

import edu.neumont.csc415.DesktopGraphics;

/**
 * Created by jmalasics on 1/24/14.
 */
public interface IWindowDecorator extends IWindow {

    @Override
    public void paint(DesktopGraphics desktopGraphics);

}
