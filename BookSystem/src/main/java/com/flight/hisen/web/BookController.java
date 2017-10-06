package com.flight.hisen.web;

import com.alibaba.fastjson.JSON;
import com.flight.hisen.entity.Book;
import com.flight.hisen.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList(0, 10);
        model.addAttribute("list", list);
        return "list";// WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.getById(bookId);
        model.addAttribute("book", book);
        return "detail";
    }


    @RequestMapping(value = "/update/{bookId}", method = RequestMethod.POST)
    @ResponseBody
    private String update(@PathVariable Long bookId, Book book, Model model) {
        model.addAttribute("book", book);
        int i = -2;
        if (book != null){
            i = bookService.updateBook(book);
        }
        return i > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    private String deleteBookById(@PathVariable("bookId") Long id) {
        int i = bookService.deleteBookById(id);
        return i > 0 ? "success" : "error";
    }

    /**
     * 查询总页数
     * @return
     */
    @RequestMapping(value = "/countNum", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    private int countNum() {
        int num = bookService.countNum();
        //计算页数，如果除以10有余数，得加上一页
        int countNum = num / 10 + ((num % 10) > 0 ? 1 : 0);
        return countNum;
    }

    /**
     * 分页查询方法
     * @param start
     * @return
     */
    @RequestMapping(value = "/listpage", method = RequestMethod.POST)
    @ResponseBody
    private String listPage(@RequestParam("start") int start){
        //默认10条
        List<Book> list = bookService.getList(start, 10);
        //阿里fastjson把数组转换为json
        String bookString = JSON.toJSONString(list);
//        System.out.println("列出来的书籍"+bookString);
        return bookString;
    }

}