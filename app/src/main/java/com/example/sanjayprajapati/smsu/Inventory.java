package com.example.sanjayprajapati.smsu;

/**
 * Created by sanjayprajapati on 4/11/18.
 */

public class Inventory {
    int upc;
    String label;
    String description;
    double price;
    int quantiy;
    public Inventory(int upc,String label,String description,double price,int quantiy){
        this.upc=upc;
        this.label=label;
        this.description=description;
        this.price=price;
        this.quantiy=quantiy;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }
}
