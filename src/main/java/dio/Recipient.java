package dio;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Alex on 01.03.15.
 */
public class Recipient implements ApplicationContextAware, BeanNameAware, DisposableBean, Observer {
    private String name;
    private Subject topic;
    private ApplicationContext applicationContext;

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("New bean name = " + s);
        name = s;

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BEAN DESTROYED");
    }

    public void printBeanName() {
        System.out.println("Bean name : " + name);
        System.out.println("Current bean : " + this.toString());
    }
}
