package main.factory;

import main.logic.House;

import java.util.ArrayList;
import java.util.List;

public class HouseFactory {
    public static List<House> createHouses() {
        ArrayList<House> houses = new ArrayList<>();
        houses.add(new House(1, 100, 1, 2, 100000, "Коваленко"));
        houses.add(new House(2, 200, 1, 3, 200000, "Петренко"));
        houses.add(new House(3, 300, 2, 4, 300000, "Іванченко"));
        houses.add(new House(4, 200, 2, 3, 200000, "Бондар"));
        houses.add(new House(5, 100, 3, 2, 100000, "Коваленко"));
        houses.add(new House(6, 300, 3, 4, 300000, "Мельник"));
        return houses;
    }
}