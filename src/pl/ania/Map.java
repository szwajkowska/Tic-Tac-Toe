package pl.ania;

import java.util.HashMap;

public class Map {

    java.util.Map<String, Coordinates> map = new HashMap<>();

    public Map() {
        map.put("A1", new Coordinates(0, 0));
        map.put("A2", new Coordinates(1, 0));
        map.put("A3", new Coordinates(2, 0));
        map.put("B1", new Coordinates(0, 1));
        map.put("B2", new Coordinates(1, 1));
        map.put("B3", new Coordinates(2, 1));
        map.put("C1", new Coordinates(0, 2));
        map.put("C2", new Coordinates(1, 2));
        map.put("C3", new Coordinates(2, 2));
    }
}
