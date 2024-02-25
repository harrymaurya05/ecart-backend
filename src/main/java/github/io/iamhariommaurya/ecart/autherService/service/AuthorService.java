package github.io.iamhariommaurya.ecart.autherService.service;

import github.io.iamhariommaurya.ecart.autherService.model.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);
    List<Author> getAllAuthors();
    Author getAuthorByid(long id);
    Author updateAuthorById(long id, Author author);
    String deleteAuthorByid(long id);
}
