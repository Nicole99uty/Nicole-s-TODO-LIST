package ui.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegularItem extends Item{
//    public List<Item> todos= new ArrayList<>();


    public RegularItem(String name, Boolean status, Date dueDate, Integer hours) {
        super(name, status, dueDate, hours);
    }

    @Override
    public Date getDueDate() {
       return getDueDate( "This is not urgent so far but you may want to finish in advance");
    }


    @Override
    public Integer gethourNeed(){
        return hourNeed;
    }

    @Override
    public String toString() {
//        return "RegularItem{" +
//                "name='" + name + '\'' +
//                ", status=" + status +
//                ", dueDate=" + dueDate +
//                ", hourNeed=" + hourNeed +
//                '}';
        return name +" (This is not so urgent)";
    }
}



