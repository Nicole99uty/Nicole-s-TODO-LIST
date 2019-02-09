package ui.model;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URL;
import java.util.List;

public class TodoList implements Saveable, Loadable {

    private ArrayList<Item> todos = new ArrayList<>();
    private Scanner keyboard = new Scanner(System.in);
    private locationManager locationManager = new locationManager();


    public void start() {
        String operation = " ";

        // load here
        while (true) {
            int a = 2;
            for (int i = 1; i <= a; i++) {
                if (i == 1) {
                    System.out.println("Welcome to TODOLIST!");
                } else {
                    System.out.println("Have a nice day!");
                }

            }

            deliverInstruction("[1] add a to do list item");
            deliverInstruction("[2] cross off an item");
            deliverInstruction("[3] show the item");
            deliverInstruction("[4] save the list");
            deliverInstruction("[5] load the list");
            deliverInstruction("[6] see the item list");
            deliverInstruction("[7] change the location of the item");
            deliverInstruction("[quit] you would stop the operation");

            operation = keyboard.nextLine();


            if (operation.equals("1")) {
                scanAdd(keyboard);
            } else if (operation.equals("2")) {
                scanCrossOff(keyboard);
            } else if (operation.equals("3")) {
                show();
            } else if (operation.equals("4")) {
                try {
                    save("save");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (operation.equals("5")) {
                try {
                    load("save");
                } catch (IOException e) {
                    e.printStackTrace();
                }


//            } else if (operation.equals("6")) {
//                compositeDemo();
//            } else if (operation.equals("7")) {
                changeLocation1();
            } else if (operation.equals("quit")) {
                try {
                    save("save");
                } catch (IOException ignored) {
                }
            }
        }
    }

    private void deliverInstruction(String s) {
        System.out.println("--" + s);
    }


    //MODIFIES:this
    //EFFECTS: add the operation to the to do list
    public void add(String o1, Boolean o2, Date o3, Integer o4, boolean urgent)  {
//        if (todos.size() > 4) {
//            throw new TooManyThingsToDo("You have too many items in the todo list haven't done, you should cross off some!");
//        }
        if (urgent) {
            createUrgentItem(o1, o2, o3, o4);
        } else {
            createRegularItem(o1, o2, o3, o4);
        }


    }

    private void createRegularItem(String o1, Boolean o2, Date o3, Integer o4) {
        RegularItem s1 = new RegularItem(o1, o2, o3, o4);
        todos.add(s1);
    }

    private void createUrgentItem(String o1, Boolean o2, Date o3, Integer o4) {
        UrgentItem s2 = new UrgentItem(o1, o2, o3, o4);
        todos.add(s2);
    }

    //EFFECTS: if the to do list contains the item we are going to find return true, otherwise false
    public boolean todosContains(String item) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName().equalsIgnoreCase(item)) {
                return true;
            }

        }
        return false;
    }

    //EFFECTS:return the size of the to do list
    public int todosSize() {
        return todos.size();
    }


    //REQUIRES:the to do list is not empty and the item is listed in the to do list
    //MODIFIES:this
    //EFFECTS: cross off the operation exist in the to do list, otherwise returns "The object is not found!"
    public void crossOff(String s) throws ItemnotfoundException {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName().equalsIgnoreCase(s)) {
                todos.remove(i);
                return;
            }
        }
        throw new ItemnotfoundException("The object is not found!");
    }

    //EFFECTS:show get item added in the to do list
    public void show() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println(todos.get(i).getName() + todos.get(i).getDueDate() + todos.get(i).gethourNeed());
        }
    }

    //EFFECTS: scan the keyboard and add the operation
    //MODIFIES: this
    public void scanAdd(Scanner scanner) {
        System.out.println("what would you like to add ?");
        String operation = scanner.nextLine();
        System.out.println("which todo list you would like to add to?");
        String locationName = scanner.nextLine();
        System.out.println("you selected: " + locationName);
        Location location = locationManager.getLocation(locationName);
        System.out.println("When is this due?");
        String date = scanner.nextLine();
        System.out.println("How many hours will this take?");
        int hours = scanner.nextInt();
        scanner.nextLine();
        System.out.println("is this urgent?");
        boolean urgent = scanner.nextBoolean();
        scanner.nextLine();
        try {
            add(operation, false, new SimpleDateFormat("yyyy/MM/dd").parse(date), hours, urgent);
        } catch (ParseException e) {
            System.out.println("Invalid date");
//        } catch (TooManyThingsToDo e) {
//            System.out.println(e.getMessage());
//        } finally {
            System.out.println("An item has been added.");
        }
    }

    //EFFECTS: scan the keyboard and cross off the operation
    //MODIFIES:this
    public void scanCrossOff(Scanner scanner) {
        System.out.println("what would you like to remove ?");
        String operation = scanner.nextLine();
        System.out.println("you selected: " + operation);
        try {
            crossOff(operation);
        } catch (ItemnotfoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("An item has been crossed off");
        }
    }

    public static void main(String[] args) throws IOException {
//        new TodoList1();
        new TodoList().start();
        BufferedReader br = null;

        try {
            String theURL = "https://newton.now.sh/factor/x^2+2x";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }

            for(int k=0;k<2;k++)
                return k;
        }
    }

//    static void compositeDemo() {
//        ItemList i1 = new ItemList("Today's task");
//        ItemList i2 = new ItemList("HouseHoldDuty");
//        ItemList i3 = new ItemList("HomeWork");
//        i3.addChild(new RegularItem("Math assignment", false, null, 5, null));
//        i3.addChild(new UrgentItem("Stat lab", false, null, 1, null));
//        i2.addChild(new RegularItem("Wash dishes", false, null, 1, null));
//        i2.addChild(new UrgentItem("Laundry", false, null, 2, null));
//        i1.addChild(i2);
//        i1.addChild(i3);
//        i1.addChild(new RegularItem("exercise", false, null, 2, null));
//        i1.print();
//    }

    //MODIFIES:this
    //EFFECTS:load the todolist from the saving file
    @Override
    public void load(String saving_file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saving_file + ".txt"));

        for (String line : lines) {
            Item item;
            if (line.startsWith("urgent: ")) {
                line = line.replace("urgent: ", "");
                item = new UrgentItem(null, false, null, -1);
            } else {
                line = line.replace("regular: ", "");
                item = new RegularItem(null, false, null, -1);
            }
            String[] input = line.split(":");
            item.setName(input[0]);
            item.sethourNeed(Integer.parseInt(input[3]));
            try {
                item.setDueDate(SimpleDateFormat.getDateInstance().parse(input[2]));
            } catch (ParseException e) {
                // ignore
            }
            item.setStatus(Boolean.parseBoolean(input[1]));
            todos.add(item);


        }
    }

    //MODIFIES:saving txt
    //EFFECTS:save the todolist to the saving file
    @Override
    public void save(String saving_file) throws IOException {
        PrintWriter writer = new PrintWriter(saving_file + ".txt", "UTF-8");
        List<String> lines = new ArrayList<>();

        for (Item todo : todos) {
            String type = todo instanceof UrgentItem ? "urgent" : "regular";
            lines.add(type + ": " + todo.getName() + ":" + todo.getStatus() + ":" + SimpleDateFormat.getDateInstance().format(todo.getDueDate()) + ":" + todo.gethourNeed());
        }
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }

    public void changeLocation1() {
        System.out.println("Please enter the name of the item you want to change location");
        String itemName = keyboard.nextLine();
        System.out.println("Please enter the new location of your item");
        String newName = keyboard.nextLine();
        for (Item i : todos) {
            if (itemName == i.getName()) {
                i.setLocation(new Location(newName));
            }
        }

    }

    public ArrayList<Item> getTodos() {
        return todos;
    }
}




