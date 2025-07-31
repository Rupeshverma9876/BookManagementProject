package com.book.management.controller;

import com.book.management.service.mybooklistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mybooklistcontroller {
    @Autowired
    private mybooklistservice service;
    @RequestMapping("/deletemylist/{id}")
    public String deletemylist(@PathVariable("id") int id){
        service.deletebyid(id);
        return "redirect:/MyBook";
    }

}
