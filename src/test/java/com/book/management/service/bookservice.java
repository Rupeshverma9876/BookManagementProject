package com.book.management.service;

import com.book.management.entity.book;
import com.book.management.repository.bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookservice {

    @Autowired
    private bookrepository brepo;

    public void save(book b){
        brepo.save(b);
    }
    public List<book> getallbook(){
        return brepo.findAll();
    }
    public book getbookbyid(int id){
        return brepo.findById(id).get();
    }
}
