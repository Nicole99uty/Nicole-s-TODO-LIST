package ui.model;

import java.util.Date;

public class UrgentItem extends Item{
    public UrgentItem(String name, Boolean status, Date dueDate, Integer hours) {
        super(name, status, dueDate, hours);
    }

    @Override
    public Date getDueDate(){
        return getDueDate("Urgent!!!This is due today");}

    @Override
    public Integer gethourNeed(){
        Date today =new Date();
        if((dueDate.before(today))&&hourNeed>=4){
            System.out.println("This may cost you a lot of time!");
        }

        return hourNeed;}


    @Override
    public String toString() {
        return name  +" (Urgent!!!This is due today)";
//                "UrgentItem{" +
//                "name='" + name + '\'' +
//                ", status=" + status +
//                ", dueDate=" + dueDate +
//                ", hourNeed=" + hourNeed +
//                '}';
    }
}
