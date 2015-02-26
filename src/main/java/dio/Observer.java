package dio;

/**
 * Created by Alex on 25.02.15.
 */
public interface Observer {

    //attach with subject to observe
    public void setSubject(Subject sub);
    public void update();
}
