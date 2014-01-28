package Interface;

/**
 * Created by jmalasics on 1/15/14.
 */
public interface ISubject {

    public void registerObserver(IObserver observer);

    public void removeObserver(IObserver observer);

    public void notifyObservers();

}
