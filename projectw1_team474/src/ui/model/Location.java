package ui.model;

import java.util.*;

public class Location {
    Set<Item> items;
    String name;


    Location(String  name) {
        items = new HashSet<>();
        this.name=name;


    }

    void addItem(Item i) {
            items.add(i);
            i.setLocation(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

//    public void changeLocation(){
//        System.out.println("Please enter the name of the item you want to change location");
//        String itemName= keyboard.nextLine();
//        System.out.println("Please enter the new location of your item");
//        String newName=keyboard.nextLine();
//        for(Item i:todos){
//            if(itemName==i.getName()){
//                i.setLocation(new Location(newName));
//            }
//        }
//        TodoList todo = new TodoList();
//        todo.changeLocation1();
//        setChanged();
//        notifyObservers();
//
//    }

}



