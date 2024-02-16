package github.io.iamhariommaurya.ecart.reviewService.repository;

import github.io.iamhariommaurya.ecart.reviewService.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
