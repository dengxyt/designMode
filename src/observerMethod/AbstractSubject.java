package observerMethod;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject implements Subject {
	
    private List<Observer> cow = new CopyOnWriteArrayList<Observer>();  
    
    @Override  
    public void add(Observer observer) {  
    	cow.add(observer);  
    }  
  
    @Override  
    public void del(Observer observer) {  
    	cow.remove(observer);  
    }  
  
    @Override  
    public void notifyObservers() {  
    	for (Observer observer : cow) {
    		observer.update();
		}
    }  

}
