package com.spartaonline.learn.jpa;

import javax.persistence.*;

/**
 * Created by vladimir on 22.11.15.
 */
@Entity
@Table(name = "items")
public class Item {

    @Id
    @SequenceGenerator(
            name="items_id_seq",
            sequenceName="items_id_seq",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="items_id_seq")
    private int id;

    private String name;

    @Column(name = "cost")
    private double price;

    private boolean active;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}
