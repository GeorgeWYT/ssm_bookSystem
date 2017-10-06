package com.flight.test;

import com.flight.hisen.dao.BookDao;
import com.flight.hisen.entity.Book;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class BookDaoTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BookDao bookDao;

    @Test
    public void addBook() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setDetail("描述" + i);
            book.setName("活着" + i);
            book.setNumber(i + 110);
            int num = bookDao.addBook(book);
            System.out.println(num);
        }
    }

    @Test
    public void queryById() {
        Book book = bookDao.queryById(4);
        System.out.println("101的书籍信息："+book);
    }

    @Test
    public void queryAll() {
        List<Book> books = bookDao.queryAll(1, 1000);
        System.out.println(books);
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setBookId(1);
        book.setDetail("描述---修改");
        book.setName("活着---修改");
        book.setNumber(100);
        int num = bookDao.updateBook(book);
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(1);
    }
}