package entities;

import enums.CategoryProduct;

import java.util.Random;

public class Product {
    //ATTRIBUTI
    private final long id;
    private String name;

    private CategoryProduct category;
    private double price;

    //COSTRUTTORE

    public Product(String name, CategoryProduct category, double price) {
        this.id = generateId();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    //METODI

    private long generateId() {
        Random rndm = new Random();
        return 1 + rndm.nextInt(1000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryProduct getCategory() {
        return category;
    }

    public void setCategory(CategoryProduct category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
