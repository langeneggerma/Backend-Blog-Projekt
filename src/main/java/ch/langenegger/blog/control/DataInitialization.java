package ch.langenegger.blog.control;

import ch.langenegger.blog.entity.Author;
import ch.langenegger.blog.entity.Blog;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {
    @Inject
    BlogService blogService;
    @Inject
    AuthorService authorService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data only if there is no Data around

        if(blogService.count() < 1 && authorService.count() < 1) {
            authorService.addAuthor(new Author("Markus", "Langenegger"));
            authorService.addAuthor(new Author("Peter", "Markus"));
        }
        if(blogService.count() < 1) {
            var blog1 = new Blog("Test Blog", "This is my testing blog",authorService.getAuthor(1L));
            var blog2 = new Blog("Test Blog 2", "This is my testing blog", authorService.getAuthor(2L));
            blogService.addBlog(blog1);
            blogService.addBlog(blog2);
        }

    }
}