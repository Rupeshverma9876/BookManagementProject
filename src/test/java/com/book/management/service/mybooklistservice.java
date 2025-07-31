package com.book.management.service;

import com.book.management.entity.mybooklist;
import com.book.management.repository.mybooklistrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mybooklistservice {
@Autowired
    private mybooklistrepository mybook;
public  void savemybooklist(mybooklist book){
    mybook.save(book);
}
public List<mybooklist> getallmybook(){
    return mybook.findAll();
}
public void deletebyid(int id){
    mybook.deleteById(id);
}

}
