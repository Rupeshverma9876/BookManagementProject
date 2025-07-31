package com.book.management.controller;

import com.book.management.entity.book;
import com.book.management.entity.mybooklist;
import com.book.management.service.bookservice;
import com.book.management.service.mybooklistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class bookcontroller {

    @Autowired
    private bookservice service;
    @Autowired
    private mybooklistservice mybookservice;
    @GetMapping("/home")
    public  String home(){
        return "home";
    }
    @GetMapping("/BookRegister")
    public String BookRegister(){
        return "BookRegister";
    }
    @GetMapping("/AvailableBook")
    public ModelAndView getAllBook(){
        List<book> list = service.getallbook();
        ModelAndView m = new ModelAndView();
//        m.setViewName("AvailableBook");
////        m.addObject()
        return new ModelAndView("AvailableBook","book",list);
    }
@PostMapping("/save")
public  String bookadd(@ModelAttribute book b){
        service.save(b);
        return "redirect:/AvailableBook";
}
@GetMapping("/MyBook")
    public  String getmybook(Model model){
        List<mybooklist> list = mybookservice.getallmybook();
        model.addAttribute("book",list);
        return "addtomybook";
}


@RequestMapping("/mylist/{id}")
    public String getmylist(@PathVariable("id") int id){
    book b = service.getbookbyid(id);
    mybooklist mb = new mybooklist(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    mybookservice.savemybooklist(mb);
        return "redirect:/MyBook";

}
    @RequestMapping("/editbook/{id}")
    public String editbook(@PathVariable("id") int id, Model model){
        book b = service.getbookbyid(id);
        model.addAttribute("book", b);
        return "bookedit";
    }
}
