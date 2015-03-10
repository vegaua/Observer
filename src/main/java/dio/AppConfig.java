package dio;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by OGolosun on 3/6/15.
 */

@Configuration
@Profile("dev")
@PropertySource("classpath:bean.properties")
public class AppConfig {

    @Profile("dev")
    public ConcreteObserver observer() {
        return new ConcreteObserver();
    }

}
