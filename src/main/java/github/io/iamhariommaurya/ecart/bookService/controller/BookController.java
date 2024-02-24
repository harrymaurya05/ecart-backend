package github.io.iamhariommaurya.ecart.bookService.controller;

import github.io.iamhariommaurya.ecart.bookService.model.Book;
import github.io.iamhariommaurya.ecart.bookService.model.BookResponseDTO;
import github.io.iamhariommaurya.ecart.bookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/book")
public class BookController {
    @Autowired
    BookService bookService;
    //Add Book
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }
    //Get Books
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books.stream()
                .map(Book::toDTO)
                .collect(Collectors.toList()));
    }
    //Get Book by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.getBookByid(id));
    }
    //Update Book
    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id,@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBookById(id,book));
    }
    //Delete Book
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.deleteBookByid(id));
    }
}
