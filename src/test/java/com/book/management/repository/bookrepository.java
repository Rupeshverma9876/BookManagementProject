package com.book.management.repository;

import com.book.management.entity.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepository extends JpaRepository<book,Integer> {

}
