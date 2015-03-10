package dio;

import org.springframework.context.ApplicationEvent;

/**
 * Created by OGolosun on 3/2/15.
 */
public class PersonEvent extends ApplicationEvent {

    public PersonEvent(Person source) {
        super(source);
    }

    @Override
    public Person getSource() {
        return (Person) super.getSource();
    }



}
