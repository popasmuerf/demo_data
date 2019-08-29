package io.thirdplanet.demo_data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import io.thirdplanet.demo_data.domains.Book;



public interface BookRepo extends JpaRepository<Book, Long>,JpaSpecificationExecutor<Book> {

}