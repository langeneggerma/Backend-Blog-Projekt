package ch.langenegger.blog.control;

import ch.langenegger.blog.entity.Author;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@Dependent
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    Logger logger;

    public List<Author> getAuthors() {
        var authors = authorRepository.listAll();
        logger.info("Returning " + authors.size() + " authors");
        return authors;
    }

    public Author getAuthor(Long id) {
        logger.info("Getting author " + id);
        return authorRepository.findById(id);
    }
    public long count(){
        logger.info("Counting authors");
        return authorRepository.count();
    }
    @Transactional
    public void addAuthor(Author author) {
        logger.info("Adding author " + author.getFirstname());
        authorRepository.persist(author);
    }

    @Transactional
    public void deleteAuthor(Author author) {
        logger.info("Deleting author " + author.getFirstname());
        authorRepository.delete(author);

    }
}
