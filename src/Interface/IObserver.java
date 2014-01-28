package Interface;

/**
 * Created by jmalasics on 1/15/14.
 */
public interface IObserver {

    public static final int X_BUFFER = 30;
    public static final int Y_BUFFER = 30;

    public void update(int keyCode);

    public void setCurrentX();

    public int getCurrentX();

    public void setCurrentY();

    public int getCurrentY();

}
