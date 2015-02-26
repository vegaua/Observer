package dio;

/**
 * Created by Alex on 25.02.15.
 */
public class ConcreteObserver implements Observer {

    private String name;
    private Subject topic;

    public ConcreteObserver() {
    }

    public ConcreteObserver(String name){
        this.name=name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }

}