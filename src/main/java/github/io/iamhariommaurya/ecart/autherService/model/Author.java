package github.io.iamhariommaurya.ecart.autherService.model;

import github.io.iamhariommaurya.ecart.bookService.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float price;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
