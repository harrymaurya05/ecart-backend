package github.io.iamhariommaurya.ecart.autherService.service;

import github.io.iamhariommaurya.ecart.autherService.model.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author book);
    List<Author> getAllBooks();
    Author getBookByid(long id);
    Author updateBookById(long id, Author book);
    String deleteBookByid(long id);
}
