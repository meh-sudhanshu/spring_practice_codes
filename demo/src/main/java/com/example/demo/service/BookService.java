package com.example.demo.service;


import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(fixedRate = 5000)
    private void readAndWriteFromDb(){
        String query = "select * from book";

        List<Book> books = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Book.class));

        for(int i = 0; i<books.size();i++){
            Book book = books.get(i);
            System.out.println(book.getIdentifier());
        }

    }
}
