package dio;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by OGolosun on 3/2/15.
 */

public class NewSubject implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    public void notifyAllObservers(Person person) {
        applicationEventPublisher.publishEvent(new PersonEvent(person));
    }
}
