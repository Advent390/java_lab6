package main.service;

import main.logic.HouseRepository;

import main.logic.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class HouseRepositoryTextImpl implements HouseRepository {
    @Override
    public void outputList(List<House> houses, File file){
        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))){
            if(houses != null){
                for(House house : houses){
                    out.println(house.getId() + ";" +
                            house.getArea() + ";" +
                            house.getFloor() + ";" +
                            house.getRooms() + ";" +
                            house.getPrice() + ";" +
                            house.getOwnerSurname() + ";");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputList(List<House> houses, String fileName){
        File file = new File(fileName);
        outputList(houses, file);
    }

    public List<House> readList(File file){
        int size = 6;
        int count = 0;
        ArrayList<House> houses = new ArrayList<>();
        try(BufferedReader in = Files.newBufferedReader(file.toPath(),StandardCharsets.UTF_8)){
            String line;
            while((line = in.readLine()) != null){
                String[] tokens = line.split(";");
                if (tokens.length != size){
                    houses.set(count, new House(
                            Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            tokens[5]
                    ));
                }
                count++;
            }
            return houses;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<House> readList(String fileName){
        File file = new File(fileName);
        return readList(file);
    }
}