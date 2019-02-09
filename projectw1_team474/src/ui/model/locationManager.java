package ui.model;

import java.util.HashMap;
import java.util.Map;

public class locationManager {
    private Map<String,Location> locationMap;
    public locationManager(){
        locationMap= new HashMap<>();
    }
    public Location getLocation(String locationName) {
        Location location;
        if(locationMap.containsKey(locationName)){ // check if a location with the given name already exists in my locationMap
            location =locationMap.get(locationName);// if it exists, give me that location with that name
        }
        else { // otherwise, create a new location with that name and add it to the map
            location = new Location(locationName);
            locationMap.put(locationName, location);
        }
        return location;
    }

}
