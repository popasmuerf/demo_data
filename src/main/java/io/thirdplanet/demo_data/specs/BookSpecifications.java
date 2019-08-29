package io.thirdplanet.demo_data.specs;

import io.thirdplanet.demo_data.domains.Book_ ;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import io.thirdplanet.demo_data.domains.Book;

public final class BookSpecifications {
    
    private BookSpecifications(){}

    public static Specification<Book> hasAuthor(String author) {

        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
               Predicate predicate  = criteriaBuilder.like(root.get(Book_.author), "%" + author + "%");
                return predicate ;
			}
        };
    }


    public static Specification<Book> hasTitle(String title){

        return new Specification<Book>(){

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get(Book_.title), "%" + title + "%") ;
                return predicate;
            }

        };
    }


    static Specification<Book> hasAuthorAndTitle(String title, String author){
        return  new Specification<Book>() {

            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get(Book_.author), "%" + author + "%" ) ;
                
                return null;
            }

        };
        
    }








}