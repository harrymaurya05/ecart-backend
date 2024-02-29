package github.io.iamhariommaurya.ecart.autherService.service.impl;


import github.io.iamhariommaurya.ecart.autherService.model.Author;
import github.io.iamhariommaurya.ecart.autherService.repository.AuthorRepository;
import github.io.iamhariommaurya.ecart.autherService.service.AuthorService;
import github.io.iamhariommaurya.ecart.bookService.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Author save(Author request) {
        Author author = new Author();
        author.setName(request.getName());

        List<Book> books = new ArrayList<>();
        for (Book bookDTO : request.getBooks()) {
            Book book = new Book();
            book.setName(bookDTO.getName());
            book.setPrice(bookDTO.getPrice());
            book.setAuthor(author); // Set the author on the book
            books.add(book);
        }

        author.setBooks(books);

        // Save the author, cascade will save the associated books
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
            return "Author removed Successfully!!";
        }
        return "Wrong Author Id!!";
    }
}
