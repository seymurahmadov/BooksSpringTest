package com.example.booksspringtest.service;

import com.example.booksspringtest.dto.BooksDTO;
import com.example.booksspringtest.entity.BooksEntity;
import com.example.booksspringtest.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public  BooksEntity addBook(BooksDTO dto){
        BooksEntity books = BooksEntity.builder()
                .id(dto.getId())
                .authorName(dto.getAuthorName())
                .bookName(dto.getBookName())
                .pageCount(dto.getPageCount())
                .build();

     return  repository.save(books);
    }

    public List<BooksEntity>  getAll(){
        Iterable<BooksEntity> all = repository.findAll();
        List<BooksEntity> booksEntities = new ArrayList<>();
        all.forEach(booksEntities::add);
        return booksEntities;

    }

    public BooksEntity updateBooks(BooksDTO dto) throws Exception {
        BooksEntity booksEntity = repository.findById(dto.getId()).orElseThrow(Exception::new);
        booksEntity.setAuthorName(dto.getAuthorName());
        booksEntity.setBookName(dto.getBookName());
        booksEntity.setPageCount(dto.getPageCount());

       return  repository.save(booksEntity);
   }

   public  void  deleteBooks(BooksDTO dto) throws Exception {
       BooksEntity booksEntity = repository.findById(dto.getId()).orElseThrow(Exception::new);
       repository.delete(booksEntity);
   }


}
