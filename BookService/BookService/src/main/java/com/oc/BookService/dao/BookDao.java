package com.oc.BookService.dao;

import com.oc.BookService.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book,Long> {
    @Query("SELECT book FROM Book book WHERE book.title like %:keyword% OR book.autor like %:keyword%")
    List<Book> findByKeyword(@Param("keyword") String keyword);
}
