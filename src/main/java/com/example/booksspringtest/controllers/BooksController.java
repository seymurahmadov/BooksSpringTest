package com.example.booksspringtest.controllers;

import com.example.booksspringtest.dto.BooksDTO;
import com.example.booksspringtest.entity.BooksEntity;
import com.example.booksspringtest.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService service;

    @PostMapping("/add")
    public BooksEntity add(@RequestBody BooksDTO dto){
      return service.addBook(dto);
    }

    @GetMapping("/get-all")
    public  List<BooksEntity>  getAll(){
       return service.getAll();
    }

    @PutMapping("/update")
    public BooksEntity updateBooks(@RequestBody BooksDTO dto) throws Exception {
       return service.updateBooks(dto);
    }

    @DeleteMapping("/delete")
    public void deleteBooks(@RequestBody BooksDTO dto ) throws Exception {
        service.deleteBooks(dto);
    }


}
