package github.io.iamhariommaurya.ecart.bookService.model;

import lombok.Data;

@Data
public class BookResponseDTO {
    private long id;
    private String name;
    private float price;
    private long authorId;

    // Constructors, getters, and setters...
}
