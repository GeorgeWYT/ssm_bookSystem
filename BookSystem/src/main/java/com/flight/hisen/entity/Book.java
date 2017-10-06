package com.flight.hisen.entity;

import java.io.Serializable;

/**
 * 图书实体类，需要实现Serializable接口以便存放在redis中
 */
public class Book implements Serializable{
    private static final long serialVersionUID = -6585930525915611849L;

    private long bookId;
    private String name;
    private int number;
    private String detail;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                '}';
    }
}
