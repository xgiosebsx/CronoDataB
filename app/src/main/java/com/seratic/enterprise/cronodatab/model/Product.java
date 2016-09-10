package com.seratic.enterprise.cronodatab.model;

/**
 * Created by Administrador on 07/09/2016.
 */
public class Product {

    public String name;
    public String image;
    public String price;
    public String brand;

    public Product(String name, String image, String price, String brand) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
