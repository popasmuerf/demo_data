package io.thirdplanet.demo_data.services;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import io.thirdplanet.demo_data.domains.Book;
import io.thirdplanet.demo_data.repos.BookRepo;
import io.thirdplanet.demo_data.repos.FooRepo;

import io.thirdplanet.demo_data.specs.BookSpecifications ;

@Service
public class BookService {


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


    //Here we create our specifications

    

    //here we peform queries using our specs....
    public List<Book> findBooksByAuthorSpec(String author){
        Specification<Book> authorSpec = BookSpecifications.hasAuthor(author);
        List<Book> bookList = bookRepo.findAll(authorSpec);
        return bookList ;
    }


    //here we peform queries using our specs....
    public List<Book> findBooksByTitleSpec(String title){
        Specification<Book> titleSpec = BookSpecifications.hasTitle(title);
        List<Book> bookList = bookRepo.findAll(titleSpec);
        return bookList ;
    }


     //here we peform queries using our specs....
     public List<Book> findBooksByAuthorTitleSpec(String author, String title){
        Specification<Book> titleSpec = BookSpecifications.hasTitle(title);
        Specification<Book> authorSpec = BookSpecifications.hasAuthor(author);

        //Object specs = Specifications.where(author).and(titleSpec);

        List<Book> bookList = bookRepo.findAll(Specifications.where(authorSpec).and(titleSpec));
        return bookList ;
    }



    
}