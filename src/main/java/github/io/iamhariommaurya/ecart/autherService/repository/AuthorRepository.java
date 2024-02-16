package github.io.iamhariommaurya.ecart.autherService.repository;

import github.io.iamhariommaurya.ecart.autherService.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
