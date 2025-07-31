package com.book.management.repository;

import com.book.management.entity.mybooklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mybooklistrepository extends JpaRepository <mybooklist,Integer>{
}
