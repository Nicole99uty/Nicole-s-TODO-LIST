package ui.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public interface Loadable {
    //MODIFIES:this
    //EFFECTS:load the todolist from the saving file
    void load(String saving_file) throws IOException;
}
