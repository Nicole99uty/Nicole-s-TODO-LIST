package ui.model;

import java.util.ArrayList;
import java.util.List;

public class ItemList implements ItemSystem {
    List<ItemSystem>children;
    protected String name;

    public ItemList(String name){
        this.name = name;
        children=new ArrayList<>();
    }

    public void addChild(ItemSystem is){
        if(!children.contains(is))
            children.add(is);
    }

    @Override
    public void print() {
        System.out.println("**ItemList: " + name);
        for(ItemSystem is:children){
            is.print();
        }
    }
}
