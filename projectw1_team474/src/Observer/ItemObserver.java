package Observer;

import java.util.Observable;
import java.util.Observer;

public class ItemObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("the item location has changed!");
    }
}
