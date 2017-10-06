package com.flight.hisen.service;

import com.flight.hisen.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(long bookId);
    List<Book> getList(int start, int pageNum);
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBookById(long id);
    int countNum();
}
