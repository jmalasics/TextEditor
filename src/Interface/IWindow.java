package Interface;

import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.IPaintable;

/**
 * Created by jmalasics on 1/24/14.
 */
public interface IWindow extends IPaintable {

    @Override
    public void paint(DesktopGraphics desktopGraphics);

}
