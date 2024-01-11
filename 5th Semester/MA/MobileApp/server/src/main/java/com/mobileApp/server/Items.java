package com.mobileApp.server;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ITEM")
public class Items {

    @GeneratedValue
    private @Id Long id;
    private String name;
    private String description;
    private double price;
    private int availableQuantity;
    private String imgURL;

    public Items() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Items(Long id, String name, String description, double price, int availableQuantity, String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.imgURL = imgURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items item = (Items) o;
        return id == item.id && Double.compare(item.price, price) == 0 && availableQuantity == item.availableQuantity && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(imgURL, item.imgURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, availableQuantity, imgURL);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }

}
