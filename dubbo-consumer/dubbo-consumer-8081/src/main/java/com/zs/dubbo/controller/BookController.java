package com.zs.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zs.dubbo.model.Book;
import com.zs.dubbo.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/6
 **/
@Controller
public class BookController {
    @Reference(loadbalance = "roundrobin")
    private IBookService bookService;

    @RequestMapping("/index")
    public String selectAllBook(Model model) {
        Map<String, Object> resultMap = bookService.selectAllBook();
        if ((Integer) resultMap.get("code")==200) {
            List<Book> bookList = (List<Book>) resultMap.get("result");
            model.addAttribute("books", bookList);
            return "index";
        }
        return "404";
    }

    @RequestMapping("/turnInsertPage")
    public String turnInsertPage() {
        return "insertBook";
    }
    @RequestMapping("/insertBook")
    public String insertBook(Book book) {
        Map<String, Object> resultMap = bookService.insertBook(book);
        if (200 == (Integer) resultMap.get("code")) {
            return "redirect:/index";
        }
        return "404";
    }

    @RequestMapping("/turnUpdatePage")
    public String turnUpdatePage(Integer id, Model model) {
        Map<String, Object> resultMap = bookService.selectBookById(id);
        if ((Integer) resultMap.get("code") == 200) {
            Book book = (Book) resultMap.get("result");
            model.addAttribute("book", book);
            return "update";
        }
        return "404";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        Map<String, Object> resultMap = bookService.updateBook(book);
        if ((Integer) resultMap.get("code") == 200) {
            return "redirect:/index";
        }
        return "404";
    }

    @RequestMapping("/deleteById")
    public String deleteBook(Integer id) {
        Map<String, Object> resultMap = bookService.deleteBookById(id);
        if (200==(Integer) resultMap.get("code")) {
            return "redirect:/index";
        }
        return "404";
    }

}
