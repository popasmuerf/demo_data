package io.thirdplanet.demo_data.services;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.thirdplanet.demo_data.domains.Book;
import io.thirdplanet.demo_data.repos.BookRepo;
import io.thirdplanet.demo_data.repos.FooRepo;

@Service
public class GameService {
@Autowired
private BookRepo  bookRepo ;

@Autowired
private FooRepo fooRepo ; 



    public List<Book> getBookListing() {
        List<Book> bookListing = bookRepo.findAll() ;
        return bookListing ;
    }

    public List<Book> getBookByAuthor(String author){

        List<Book> bookListing = fooRepo.findBooksByAuthor(author);
        return bookListing ;
    }


    public List<Book> getBookByTitle(String title){

        List<Book> bookListing = fooRepo.findBooksByTitle(title);
        return bookListing ;
    }

    public List<Book> getBookByAuthorAndTitle(String author, String title){

        List<Book> bookListing = fooRepo.findBooksByAuthorNameAndTitle(author, title);
        return bookListing ;
    }


    
}