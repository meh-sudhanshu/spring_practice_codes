package com.ugb.BookCRUD.services;


import com.ugb.BookCRUD.exceptions.DuplicateIdentifierException;
import com.ugb.BookCRUD.models.Book;
import com.ugb.BookCRUD.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book save(Book book){

        try{
            return bookRepository.save(book);
        }catch (Exception e){
            throw new DuplicateIdentifierException("Identifier already exists");
        }
    }



}
