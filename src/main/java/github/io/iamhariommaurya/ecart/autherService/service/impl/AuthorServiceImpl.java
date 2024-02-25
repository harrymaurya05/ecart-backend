package github.io.iamhariommaurya.ecart.autherService.service.impl;


import github.io.iamhariommaurya.ecart.autherService.model.Author;
import github.io.iamhariommaurya.ecart.autherService.repository.AuthorRepository;
import github.io.iamhariommaurya.ecart.autherService.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByid(long id) {
        Optional<Author> book = authorRepository.findById(id);
        return book.orElse(null);
    }

    public Author updateAuthorById(long id, Author author) {
        Optional<Author> book1 = authorRepository.findById(id);
        if(book1.isPresent()){
            Author originalAuthor= book1.get();
            if(Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())){
                originalAuthor.setName(author.getName());
            }
            return authorRepository.save(originalAuthor);
        }
        return null;
    }

    @Override
    public String deleteAuthorByid(long id) {
        if(authorRepository.findById(id).isPresent()){
            authorRepository.deleteById(id);
            return "Author Removed Successfully!!";
        }
        return "Invalid Author Id!!";
    }
}
