package main;

import main.controller.*;
import main.factory.*;

public class Main {

    private final HouseController houseController = new HouseController();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        houseController.controller(HouseFactory.createHouses());
    }
}