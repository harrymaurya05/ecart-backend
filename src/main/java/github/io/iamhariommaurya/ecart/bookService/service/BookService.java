package github.io.iamhariommaurya.ecart.bookService.service;

import github.io.iamhariommaurya.ecart.bookService.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> getAllBooks();
    Book getBookByid(long id);
    Book updateBookById(long id,Book book);
    String deleteBookByid(long id);
}
