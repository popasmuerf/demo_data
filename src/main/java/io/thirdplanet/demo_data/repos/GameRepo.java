package io.thirdplanet.demo_data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import io.thirdplanet.demo_data.domains.Book;


/**
 * After we have extended the JpaSpecificationExecutor interface, the classes that use
 * our repository interface get access to the the follwong methods....
 * 
 * 
 * long  count (Specification<T> spec)  ;
 * List<T> findAll(Specification<T> spec) ;
 * T findOne(Specification<T> spec)
 * 
 * 
 * The JpaSpecificationExecutor<T> interface declares also tow other methods that used
 * to sort and paginate objects that fufil the conditions specified bythe Specification<T>
 * object.  We will talk more abou these methods when we learn to sort and paginate 
 * our query results.
 * 
 * 
 * Specifying the Conditions of the Invoked Database Query
 * ===============================================================
 * 1. Crate a new Specification<T>  object
 * 
 * 2. Set the type of the quired entity as the value of th type parameter (T)
 * 
 * 3. Specify the conditions by implementing the toPredicate() method of the Specification<T> interface
 * 
 *  #Example code
 * 
 * new Specification<Book>(){
 *      @Override
 *      public Predicate toPredicate(Root<Todo> root, CriteriaQuery<?>, CriteriaBuilder cb){
 *          #Create the query by using the 
 *      }
 * 
 * }
 * 
 * 
 * Where should we create these Specifications<T> objects ?
 * ============================================================
 * 
 * I argue that we chould create our Specification<T> objects by using specifcation builder classes
 * because:
 * 
 *  -   We can put our query generation logic into one place.  In other words, we don't 
 *      litter the source ocode of our service classes(or other components) with the query
 *      generation logic
 * 
 * -    We can create reusable specifications and combine  them in the classes that invoke
 *      our database queries.
 * 
 * 
 * 
 * 
 * 
 */

public interface GameRepo extends JpaRepository<Book, Long> ,JpaSpecificationExecutor<Book>{

}