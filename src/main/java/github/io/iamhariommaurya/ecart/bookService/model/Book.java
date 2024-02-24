package github.io.iamhariommaurya.ecart.bookService.model;

import github.io.iamhariommaurya.ecart.autherService.model.Author;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float price;

    @ManyToOne
    @JoinColumn(name = "author_id") // specify the foreign key column
    private Author author;


    public BookResponseDTO toDTO() {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setPrice(this.price);

        if (this.author != null) {
            dto.setAuthorId(this.author.getId());
        }

        return dto;
    }

}
