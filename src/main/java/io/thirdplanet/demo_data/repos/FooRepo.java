package io.thirdplanet.demo_data.repos;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.thirdplanet.demo_data.domains.Book;

@Repository 
public class FooRepo {
    @PersistenceContext
    private EntityManager em ;

    Predicate getBookListPredicate(){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Instance of the criteria query, configured for querying Book entitiy objects
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying for all book records

        
        return null ;
    }



    Predicate getBookByIdPredicate(){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Instance of the criteria query, configured for querying Book entitiy objects
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying for all book records
        return null ;
    }


    Predicate getBookByAuthorPredicate(String author){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Instance of the criteria query, configured for querying Book entitiy objects
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying for all book records
        Predicate authorPredicate = cb.equal(bookRoot.get("author"), author) ;
        return authorPredicate ;
    }

   public  Predicate getBookByTitle(String title){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Instance of the criteria query, configured for querying Book entitiy objects
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying for all book records
        Predicate titlePredicate = cb.equal(bookRoot.get("title"), title);
        return titlePredicate ;
    }


    public List<Book> findBooksByAuthor(String author){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Instance of the criteria query, configured for querying Book entitiy objects
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying for all book records
        Predicate authorPredicate = cb.equal(bookRoot.get("author"), author) ;
        cq.where(authorPredicate) ;
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList() ;
    }


    public List<Book> findBooksByTitle(String title){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder() ;
        //Instance of the criteria query, configured for querying Book entity objects...Book
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        //Instance of the object that forms the root of the Book Entity graph 
        Root<Book> bookRoot = cq.from(Book.class);
        //Instance of the predicate for querying all book redcords in the graph
        Predicate titlePredicate = cb.like(bookRoot.get("title"), "%" + title + "%");
        //Build the query....
        cq.where(titlePredicate);
        TypedQuery<Book> query = em.createQuery(cq);
        //execute query....
        List<Book> bookList = query.getResultList() ;

        return bookList ;
    }

   public  List<Book> findBooksByAuthorNameAndTitle(String author,String title){
        //Instance of our criteria builder
        CriteriaBuilder cb = em.getCriteriaBuilder() ;
        //Instance of query string builder
        CriteriaQuery<Book> cq = cb.createQuery(Book.class) ;
        //Instance of root of query graph 
        Root<Book> bookRoot = cq.from(Book.class) ;
        //Instance of author Predicate
        Predicate authorPredicate = cb.equal(bookRoot.get("author"), author);
        //Instance of author Predicate 
        Predicate titlePredicate = cb.like(bookRoot.get("title"), "%" + title  +"%");
        //Build the query..."AND"
        cq.where(authorPredicate,titlePredicate);
        TypedQuery<Book> query = em.createQuery(cq);

        List<Book> bookList = query.getResultList() ;
    
        return bookList ;
    }

   

}