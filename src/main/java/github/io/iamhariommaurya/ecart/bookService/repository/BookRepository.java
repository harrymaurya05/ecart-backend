package github.io.iamhariommaurya.ecart.bookService.repository;

import github.io.iamhariommaurya.ecart.bookService.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
