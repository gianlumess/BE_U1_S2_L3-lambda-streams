package entities;

import java.util.Random;

public class Customer {
    //ATTRIBUTI
    private final long id;
    private String name;
    private int tier;

    //COSTRUTTORE

    public Customer(String name, int tier) {
        this.id = generateId();
        this.name = name;
        this.tier = tier;
    }

    //METODI

    private long generateId() {
        Random rndm = new Random();
        return 1 + rndm.nextInt(1000);
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
