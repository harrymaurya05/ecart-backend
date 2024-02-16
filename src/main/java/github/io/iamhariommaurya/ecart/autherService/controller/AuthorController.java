package github.io.iamhariommaurya.ecart.autherService.controller;

import github.io.iamhariommaurya.ecart.autherService.model.Author;
import github.io.iamhariommaurya.ecart.autherService.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    //Add Book
    @PostMapping
    public ResponseEntity<Author> saveBook(@RequestBody Author book){
        return ResponseEntity.ok(authorService.save(book));
    }
    //Get Books
    @GetMapping
    public ResponseEntity<List<Author>> getBooks(){
        return ResponseEntity.ok(authorService.getAllBooks());
    }
    //Get Book by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(authorService.getBookByid(id));
    }
    //Update Book
    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> updateBook(@PathVariable("id") long id, @RequestBody Author book){
        return ResponseEntity.ok(authorService.updateBookById(id,book));
    }
    //Delete Book
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(authorService.deleteBookByid(id));
    }
}
