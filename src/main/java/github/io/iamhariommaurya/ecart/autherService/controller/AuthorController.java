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
    //Add Author
    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.save(author));
    }
    //Get Authors
    @GetMapping
    public ResponseEntity<List<Author>> getAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    //Get Author by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id){
        return ResponseEntity.ok(authorService.getAuthorByid(id));
    }
    //Update Author
    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id, @RequestBody Author Author){
        return ResponseEntity.ok(authorService.updateAuthorById(id,Author));
    }
    //Delete Author
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") long id){
        return ResponseEntity.ok(authorService.deleteAuthorByid(id));
    }
}
