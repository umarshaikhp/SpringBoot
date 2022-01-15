package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Component
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // static List<Book> list = new ArrayList<>();

    // static {
    //     list.add(new Book(1, "complete java reference", "james"));
    //     list.add(new Book(2, "complete python reference", "guido"));
    //     list.add(new Book(3, "complete c reference", "riche"));
    // }

    // get All Books
    public List<Book> getAllBooks() {
       List<Book> list = (List<Book>) this.bookRepository.findAll();
       return list;


    }

    // get Single Book by id
    public Book getBookById(int id) {
        Book book = null;
        // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
       book = this.bookRepository.findById(id);
        return book;
    }

    // adding the book
    public Book addBook(Book b) {
        // list.add(b);
       Book result = bookRepository.save(b);
        return result;

    }

    // delete Book
    public void deleteBook(int bId) {
        // list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
         this.bookRepository.deleteById(bId);
    }

    // update book
    public void updateBook(Book book,int bookId){
    //   list =  list.stream().map(b->{
    //         if(b.getId() == bookId){
    //             b.setAuthor(book.getAuthor());
    //             b.setTitle(book.getTitle());
    //         }
            
    //         return b;

    //     }).collect(Collectors.toList());
    // book id and bookId may be posssible it is different that's why i am setting that id in book
    book.setId(bookId);
    this.bookRepository.save(book);
    }

}
