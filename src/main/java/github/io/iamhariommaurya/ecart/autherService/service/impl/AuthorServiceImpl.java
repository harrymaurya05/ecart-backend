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
    private AuthorRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Author save(Author book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Author> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author getBookByid(long id) {
        Optional<Author> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Author updateBookById(long id, Author author) {
        Optional<Author> book1 = bookRepository.findById(id);
        if(book1.isPresent()){
            Author originalAuthor= book1.get();
            if(Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())){
                originalAuthor.setName(author.getName());
            }
            if(Objects.nonNull(author.getPrice()) && author.getPrice() > 0){
                originalAuthor.setPrice(author.getPrice());
            }
            return bookRepository.save(originalAuthor);
        }
        return null;
    }

    @Override
    public String deleteBookByid(long id) {
        if(bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return "Book Moved Successfully!!";
        }
        return "Invalid Book Id!!";
    }
}
