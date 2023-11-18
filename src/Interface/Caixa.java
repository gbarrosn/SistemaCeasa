/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

public class Caixa {
    // Attributes
    private int price;
    private int load;
    private String name;

    // Constructor
    public Caixa(int price, int load, String name) {
        this.price = price;
        this.load = load;
        this.name = name;
    }

    // Getter and Setter methods
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method to display the object as a string
    @Override
    public String toString() {
        return "Caixa{" +
                "price=" + price +
                ", load=" + load +
                ", name='" + name + '\'' +
                '}';
    }
}
