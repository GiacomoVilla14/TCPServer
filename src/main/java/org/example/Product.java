package org.example;

public class Product {
    public String codice;
    public String name;
    public double cost;

    public Product(String codice, String name, double cost) {
        this.codice = codice;
        this.name = name;
        this.cost = cost;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
