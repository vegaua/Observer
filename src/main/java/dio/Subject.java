package dio;

/**
 * Created by Alex on 25.02.15.
 */
public interface Subject {

    public void register(Observer obs);
    public void unregister(Observer obs);
    public void notifyObservers();
    public Object getUpdate(Observer obs);

}
