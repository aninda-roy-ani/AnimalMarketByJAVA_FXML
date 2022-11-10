/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

/**
 *
 * @author Dell
 */
public class Animal {
    private String name;
    private String type;
    private String colour;
    private String price;
    private String weight;

    public Animal(String name, String type, String colour, String price, String weight) {
        this.name = name;
        this.type = type;
        this.colour = colour;
        this.price = price;
        this.weight = weight;
    }

    public Animal(String name, String type, String price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    

    public String animalDetails(){
        return name + "," + type + "," + colour + "," + price + "," + weight + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    
}
