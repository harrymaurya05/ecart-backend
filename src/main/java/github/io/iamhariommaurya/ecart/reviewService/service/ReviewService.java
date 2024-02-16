package github.io.iamhariommaurya.ecart.reviewService.service;

import github.io.iamhariommaurya.ecart.reviewService.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review book);
    List<Review> getAllBooks();
    Review getBookByid(long id);
    Review updateBookById(long id, Review book);
    String deleteBookByid(long id);
}
