package github.io.iamhariommaurya.ecart.bookService.service.impl;


import github.io.iamhariommaurya.ecart.bookService.model.Book;
import github.io.iamhariommaurya.ecart.bookService.repository.BookRepository;
import github.io.iamhariommaurya.ecart.bookService.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private  BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByid(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book updateBookById(long id, Book book) {
        Optional<Book> book1 = bookRepository.findById(id);
        if(book1.isPresent()){
            Book originalBook = book1.get();
            if(Objects.nonNull(book.getName()) && !"".equalsIgnoreCase(book.getName())){
                originalBook.setName(book.getName());
            }
            if(Objects.nonNull(book.getPrice()) && book.getPrice() > 0){
                originalBook.setPrice(book.getPrice());
            }
            return bookRepository.save(originalBook);
        }
        return null;
    }

    @Override
    public String deleteBookByid(long id) {
        if(bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return "Book Deleted Successfully!!";
        }
        return "Invalid Book Id!!";
    }
}
