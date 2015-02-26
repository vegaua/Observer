package dio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.02.15.
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers;
    private String message;

    public ConcreteSubject() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer obs) {
        if (obs == null) throw new NullPointerException("Observer is null");
        if (!observers.contains(obs)) observers.add(obs);
    }

    @Override
    public void unregister(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        observersLocal = new ArrayList(this.observers);
        for (Observer obs : observersLocal) {
            obs.update();
        }
    }

    @Override
    public Object getUpdate(Observer obs) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message posted to Topic:" + msg);
        this.message = msg;
        notifyObservers();
    }

}