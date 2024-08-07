package com.example.books_tracker.repository;

import com.example.books_tracker.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>, JpaSpecificationExecutor<Books> {
    Boolean existsBooksByISBN(String isbn);
    Boolean existsBooksByBookId(Long id);
}
