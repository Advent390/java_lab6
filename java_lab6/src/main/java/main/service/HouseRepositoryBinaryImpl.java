package main.service;

import main.logic.House;
import main.logic.HouseRepository;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class HouseRepositoryBinaryImpl implements HouseRepository {
    @Override
    public void outputList(List<House> houses, File file){
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()))){
            out.writeObject(houses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputList(List<House> houses, String fileName) {
        File file = new File(fileName);
        outputList(houses, file);
    }

    @Override
    public List<House> readList(File file){
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()))){
            Object o = in.readObject();
            return (List<House>)o;
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<House> readList(String fileName){
        File file = new File(fileName);
        return readList(file);
    }
}