package github.io.iamhariommaurya.ecart.reviewService.service.impl;


import github.io.iamhariommaurya.ecart.reviewService.model.Review;
import github.io.iamhariommaurya.ecart.reviewService.repository.ReviewRepository;
import github.io.iamhariommaurya.ecart.reviewService.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository bookRepository) {
        this.reviewRepository = bookRepository;
    }

    @Override
    public Review save(Review book) {
        return reviewRepository.save(book);
    }

    @Override
    public List<Review> getAllBooks() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getBookByid(long id) {
        Optional<Review> book = reviewRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Review updateBookById(long id, Review book) {
        Optional<Review> book1 = reviewRepository.findById(id);
        if(book1.isPresent()){
            Review originalBook = book1.get();
            if(Objects.nonNull(book.getName()) && !"".equalsIgnoreCase(book.getName())){
                originalBook.setName(book.getName());
            }
            if(Objects.nonNull(book.getPrice()) && book.getPrice() > 0){
                originalBook.setPrice(book.getPrice());
            }
            return reviewRepository.save(originalBook);
        }
        return null;
    }

    @Override
    public String deleteBookByid(long id) {
        if(reviewRepository.findById(id).isPresent()){
            reviewRepository.deleteById(id);
            return "Book Moved Successfully!!";
        }
        return "Invalid Book Id!!";
    }
}
