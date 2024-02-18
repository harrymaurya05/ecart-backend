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
    public Author save(Author book) {
        return authorRepository.save(book);
    }

    @Override
    public List<Author> getAllBooks() {
        return authorRepository.findAll();
    }

    @Override
    public Author getBookByid(long id) {
        Optional<Author> book = authorRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Author updateBookById(long id, Author author) {
        Optional<Author> book1 = authorRepository.findById(id);
        if(book1.isPresent()){
            Author originalAuthor= book1.get();
            if(Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())){
                originalAuthor.setName(author.getName());
            }
            if(Objects.nonNull(author.getPrice()) && author.getPrice() > 0){
                originalAuthor.setPrice(author.getPrice());
            }
            return authorRepository.save(originalAuthor);
        }
        return null;
    }

    @Override
    public String deleteBookByid(long id) {
        if(authorRepository.findById(id).isPresent()){
            authorRepository.deleteById(id);
            return "Author Removed Successfully!!";
        }
        return "Invalid Author Id!!";
    }
}
