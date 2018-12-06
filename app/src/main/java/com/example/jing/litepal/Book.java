package com.example.jing.litepal;

import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

public class Book extends LitePalSupport {

    private int id;
    private String author;
    private double price;
    private int page;
    private String name;
    private String press;

    public Book( String author, double price, int page, String name, String press) {
        this.author = author;
        this.price = price;
        this.page = page;
        this.name = name;
        this.press = press;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
