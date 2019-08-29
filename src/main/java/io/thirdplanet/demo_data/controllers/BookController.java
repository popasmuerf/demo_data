package io.thirdplanet.demo_data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.thirdplanet.demo_data.domains.Book;
import io.thirdplanet.demo_data.repos.BookRepo;
import io.thirdplanet.demo_data.services.BookService;


@RestController
@RequestMapping("/api")
public class BookController{

    @Autowired 
    BookService bookService  ;

    @GetMapping("/booklist")
    public List<Book> getBookListing(){
        List<Book> bookListing  = bookService.getBookListing();
        return bookListing ;
    }

    @GetMapping("/authortitle")
    public List<Book> getAuthorAndTitle(){
        List<Book> authorListing = bookService.getBookByAuthorAndTitle("Reginald Kahn","Intro to Java");
        return authorListing ;
    }


    @GetMapping("/author")
    public List<Book> getAuthor(){
        List<Book> authorListing = bookService.getBookByAuthor("Reginald Kahn");
        return authorListing ;
    }


    @GetMapping("/title")
    public List<Book> getTitle(){
        List<Book> authorListing = bookService.getBookByTitle("Intro to Java");
        return authorListing ;
    }


    @GetMapping("/authorspec")
    public List<Book> getAuthorSpec(){
        List<Book> authorListing = bookService.findBooksByAuthorSpec("Kevin Robinson");
        return authorListing ;
    }

    @GetMapping("/titlespec")
    public List<Book> getTitleSpec(){
        List<Book> titleListing = bookService.findBooksByTitleSpec("Intro to C++");
        return titleListing ;
    }

    @GetMapping("/authortitlespec")
    public List<Book> getAuthTitleSpec(){
        List<Book> titleAuthListing = bookService.findBooksByAuthorTitleSpec("Kevin Robinson", "Intro to C++");
        return titleAuthListing ;
    }


}