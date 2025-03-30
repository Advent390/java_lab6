package main.logic;

import java.io.File;
import java.util.List;

public interface HouseRepository extends Repository<House> {
    void outputList(List<House> houses, File file);

    void outputList(List<House> houses, String fileName);

    List<House> readList(File file);

    List<House> readList(String fileName);
}