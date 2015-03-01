package dio;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex on 25.02.15.
 */
public class Main {

    public static void main(String[] args) throws Exception {


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext.registerShutdownHook();

        defineBean(applicationContext,Recipient.class,Boolean.FALSE,Boolean.FALSE,Boolean.TRUE,"prototype","recipient");
        Recipient recipient = (Recipient) applicationContext.getBean("recipient");
        recipient.setBeanName("newRecipientName");
        recipient.printBeanName();
        recipient.destroy();


        ConcreteSubject topic = (ConcreteSubject) applicationContext.getBean("concreteSubject");

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

//        callContext("First");
//        callContext("Second");

    }

    public static void callContext(String message) {
        BeanFactoryLocator bfl = ContextSingletonBeanFactoryLocator.getInstance();
        BeanFactoryReference bf = bfl.useBeanFactory("mainContext");

        ConcreteSubject concreteSubject = (ConcreteSubject) bf.getFactory().getBean("concreteSubject");
        concreteSubject.postMessage(message);
    }


    public static void defineBean(ClassPathXmlApplicationContext applicationContext, Class beanClass,
                                      boolean lazyInit, boolean abstractBean, boolean autowire, String beanScope, String beanId) {

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(lazyInit);
        beanDefinition.setAbstract(abstractBean);
        beanDefinition.setAutowireCandidate(autowire);
        beanDefinition.setScope(beanScope);
        beanFactory.registerBeanDefinition(beanId,beanDefinition);

    }


}
