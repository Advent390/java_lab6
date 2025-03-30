package main.service;

import main.logic.House;
import main.logic.HouseRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HouseService {
    private final HouseRepository repositoryTxt = new HouseRepositoryTextImpl();
    private final HouseRepository repositoryBin = new HouseRepositoryBinaryImpl();

    public void outputListTxt(List<House> houses, String fileName) {
        repositoryTxt.outputList(houses, fileName);
    }

    public void outputListBin(List<House> houses, String fileName) {
        repositoryBin.outputList(houses, fileName);
    }

    public List<House> readListTxt(String fileName) {
        return repositoryTxt.readList(fileName);
    }

    public List<House> readListBin(String fileName) {
        return repositoryBin.readList(fileName);
    }

    public List<House> findHousesByNumberOfRooms(List<House> houses, int numberOfRooms) {
        var resultList = new ArrayList<House>();
        for (House house : houses) {
            if (house.getRooms() == numberOfRooms) {
                resultList.add(house);
            }
        }
        return resultList;
    }

    public List<House> findHousesByFloorInBetween(List<House> houses, int floorFrom, int floorTo) {
        var resultList = new ArrayList<House>();
        for (House house : houses) {
            if (house.getFloor() >= floorFrom && house.getFloor() <= floorTo) {
                resultList.add(house);
            }
        }
        return resultList;
    }

    public List<House> findHousesByArea(List<House> houses, int area) {
        var resultList = new ArrayList<House>();
        for (House house : houses) {
            if (house.getArea() >= area) {
                resultList.add(house);
            }
        }
        return resultList;
    }

    public List<House> filterHousesByOwner(List<House> houses, String ownerSurname) {
        return houses.stream()
                .filter(house -> house.getOwnerSurname().equalsIgnoreCase(ownerSurname))
                .sorted(Comparator.comparingInt(House::getId))
                .collect(Collectors.toList());
    }

    public String findOwnerByHouseId(List<House> houses, int houseId) {
        return houses.stream()
                .filter(house -> house.getId() == houseId)
                .map(House::getOwnerSurname)
                .findFirst()
                .orElse("Owner not found");
    }
}