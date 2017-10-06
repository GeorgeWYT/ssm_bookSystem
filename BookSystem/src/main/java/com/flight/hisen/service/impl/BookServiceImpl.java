package com.flight.hisen.service.impl;

import com.flight.hisen.dao.BookDao;
import com.flight.hisen.entity.Book;
import com.flight.hisen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList(int start, int pageNum) {
        return bookDao.queryAll(start, pageNum);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookById(long id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int countNum() {
        return bookDao.countNum();
    }
}
