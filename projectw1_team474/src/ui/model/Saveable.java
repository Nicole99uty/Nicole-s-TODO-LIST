package ui.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public interface Saveable {
    //MODIFIES:saving txt
    //EFFECTS:save the todolist to the saving file
     void save(String saving_file)throws IOException;

}
