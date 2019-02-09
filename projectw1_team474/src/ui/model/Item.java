package ui.model;

import Observer.ItemObserver;
import sun.font.TrueTypeFont;

import java.util.Date;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Item extends Observable implements ItemSystem {
    protected String name;
    protected Boolean status;  //true for done; false for not done
    protected Date dueDate;
    protected Integer hourNeed;//hours needed for the task
    private Location location;
    private ItemObserver itemObserver;

    public Item(String name, Boolean status, Date dueDate, Integer hours) {
        setName(name);
        this.status = status;
        this.dueDate = dueDate;
        hourNeed = hours;
        this.location=location;
        itemObserver=new ItemObserver();
        addObserver(itemObserver);
    }


    //EFFECTS: returns the name of the to do item;
    public String getName(){ return name; }

    //EFFECTS:set the name of the to do item to the given name
    //MODIFIES:this
    public void setName(String n){ name=n; }

    //EFFECTS: returns the status of the to do item;
    public Boolean getStatus() {return status;}

    //EFFECTS:set the status of the to do item to the given status
    //MODIFIES:this
    public void setStatus(Boolean s){ status = s;}

    public abstract Date getDueDate();

    //EFFECTS: returns the due date of the to do item;
    public Date getDueDate(String s){
        Date today = new Date();
        if (dueDate.after(today)){

            System.out.println(s);
        }
        return dueDate;
    }

    //EFFECTS:set the due date of the to do item to the given date
    //MODIFIES:this
    public void setDueDate(Date d){dueDate = d;}

    //EFFECTS: returns the hour needed of the to do item;
    public abstract Integer gethourNeed();

    //EFFECTS:set the hours needed of the to do item to the given hours
    //MODIFIES:this
    public void sethourNeed(Integer h){hourNeed=h;}

    //EFFECTS:decide whether the date is past due date
    public boolean pastDueDate(Date d){
        if(dueDate.after(d)){
            return false;
        }
        return true;
    }
    public void setLocation(Location l) {
        if (!location.equals(l)) {
            this.location = l;
            l.addItem(this);
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(status, item.status) &&
                Objects.equals(dueDate, item.dueDate) &&
                Objects.equals(hourNeed, item.hourNeed) &&
                Objects.equals(location, item.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, status, dueDate, hourNeed, location);
    }

    @Override
    public void print(){
        System.out.println("*Item: "+name);
    }

}
