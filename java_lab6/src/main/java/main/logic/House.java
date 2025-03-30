package main.logic;

import java.io.Serializable;

public class House implements Serializable {
    private int id;
    private int area;
    private int floor;
    private int rooms;
    private int price;
    private String ownerSurname;

    public House(int id, int area, int floor, int rooms, int price, String ownerSurname) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.price = price;
        this.ownerSurname = ownerSurname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    public String getOwnerSurname() {return ownerSurname;}

    public void setOwnerSurname(String ownerSurname) {this.ownerSurname = ownerSurname;}

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", area=" + area +
                ", floor=" + floor +
                ", rooms=" + rooms +
                ", price=" + price +
                ", ownerSurname='" + ownerSurname + '\'' +
                '}';
    }
}