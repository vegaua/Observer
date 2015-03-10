package dio;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;

/**
 * Created by OGolosun on 3/2/15.
 */
public class PersonEventListener implements ApplicationListener<PersonEvent>, BeanNameAware {

    private String name;


    @Override
    public void onApplicationEvent(PersonEvent personEvent) {
        System.out.println("We got an event with person : " + personEvent.getSource() + " for Listener " + name);
    }

    @Override
    public void setBeanName(String s) {
        this.name=name;
    }
}
