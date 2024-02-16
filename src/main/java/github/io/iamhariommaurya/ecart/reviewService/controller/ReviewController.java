package github.io.iamhariommaurya.ecart.reviewService.controller;

import github.io.iamhariommaurya.ecart.reviewService.model.Review;
import github.io.iamhariommaurya.ecart.reviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    //Add Book
    @PostMapping
    public ResponseEntity<Review> saveBook(@RequestBody Review book){
        return ResponseEntity.ok(reviewService.save(book));
    }
    //Get Books
    @GetMapping
    public ResponseEntity<List<Review>> getBooks(){
        return ResponseEntity.ok(reviewService.getAllBooks());
    }
    //Get Book by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> getBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(reviewService.getBookByid(id));
    }
    //Update Book
    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> updateBook(@PathVariable("id") long id, @RequestBody Review book){
        return ResponseEntity.ok(reviewService.updateBookById(id,book));
    }
    //Delete Book
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") long id){
        return ResponseEntity.ok(reviewService.deleteBookByid(id));
    }
}
