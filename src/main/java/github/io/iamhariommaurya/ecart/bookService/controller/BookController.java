package github.io.iamhariommaurya.ecart.bookService.controller;

import github.io.iamhariommaurya.ecart.bookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/book")
public class BookController {
    @Autowired
    BookService bookService;

    //Add Book
    
    //Delete Book
    //Update Book
    //Get Books
    //Get Book by id

}
