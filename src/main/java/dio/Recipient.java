package dio;

/**
 * Created by Alex on 01.03.15.
 */
public class Recipient implements Observer {
    private String name;
    private Subject topic;

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
