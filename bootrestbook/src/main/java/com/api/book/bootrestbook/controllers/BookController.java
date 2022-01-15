package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  // get Book handler
  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
  List<Book> list =  this.bookService.getAllBooks();
  if(list.size()<=0){
    // the build create the object of a ResponseEntity
    // we basically return two thing first response and as well as status code
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }
  
   return  ResponseEntity.of(Optional.of(list));
  }

  @GetMapping("/books/{id}")
  // id it is called as path template variable that is inside @path
  public Book getBooks(@PathVariable("id") int id) {
    return this.bookService.getBookById(id);

  }

  // new Book Handler
  @PostMapping("/books")
  
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    try{
    Book b = this.bookService.addBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(b);

  }
  catch(Exception e){
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  }

  // {} inside this we pass url template reference variable to receive id
  // to bind bookId to parameter variable we use @pathvariable

  // delete book Handler
  @DeleteMapping("/books/{bookId}")
  public void deleteBook(@PathVariable("bookId") int bookId) {
    this.bookService.deleteBook(bookId);

  }
   
  // update book handler
  @PutMapping("/books/{bookId}")
  public ResponseEntity<Book> updateBooking(@RequestBody Book book,@PathVariable("bookId") int bookId)
  {
    try {
      this.bookService.updateBook(book,bookId);
      // returning data and status code of 204 no_content
      return ResponseEntity.ok().body(book);
      
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


    }

  }

}
