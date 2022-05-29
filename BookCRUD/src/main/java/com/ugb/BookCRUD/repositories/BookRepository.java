package com.ugb.BookCRUD.repositories;

import com.ugb.BookCRUD.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
