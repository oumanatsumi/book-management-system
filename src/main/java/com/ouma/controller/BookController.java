package com.ouma.controller;

import com.ouma.pojo.Books;
import com.ouma.service.BookService;
import com.ouma.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books newBooks){
        bookService.addBook(newBooks);
        System.out.println(newBooks.toString());
        return "redirect:/book/allBook";
    }

    @RequestMapping("toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Books oldBooks = bookService.queryBookById(id);
        model.addAttribute("book", oldBooks);
        return "updateBook";
    }

    @RequestMapping("updateBook")
    public String updateBook(Model model, Books newBooks){
        bookService.updateBook(newBooks);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


}