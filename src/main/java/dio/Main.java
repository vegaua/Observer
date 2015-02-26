package dio;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 25.02.15.
 */
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:src/main/java/spring-config.xml");
        applicationContext.registerShutdownHook();
        ConcreteSubject topic = (ConcreteSubject) applicationContext.getBean("ConcreteSubject");

        //create observers
        Observer obs1 = new ConcreteObserver("Observer1");
        Observer obs2 = new ConcreteObserver("Observer2");
        Observer obs3 = new ConcreteObserver("Observer3");

        //register observers to the subject
        topic.register(obs1);
        topic.register(obs2);
        topic.register(obs3);

        //attach observer to subject
        obs1.setSubject(topic);
        obs2.setSubject(topic);
        obs3.setSubject(topic);

        //check if any update is available
//        obs1.update();

        //send message to subject
        topic.postMessage("New Message 1");

        topic.unregister(obs1);
        topic.postMessage("New Message 2");

    }
}
