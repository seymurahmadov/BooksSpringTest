package com.example.booksspringtest.repository;

import com.example.booksspringtest.entity.BooksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntity,Long> {
}
