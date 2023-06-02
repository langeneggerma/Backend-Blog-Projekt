package ch.langenegger;

import ch.langenegger.blog.author.control.AuthorService;
import ch.langenegger.blog.author.entity.Author;
import ch.langenegger.blog.control.BlogService;
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

        if(Blog.count() < 1 && Author.count() < 1) {
            authorService.addAuthor(new Author("Markus", "Langenegger"));
            authorService.addAuthor(new Author("Peter", "Markus"));
        }
        if(Blog.count() < 1) {
            var blog1 = new Blog("Test Blog", "This is my testing blog");
            var blog2 = new Blog("Test Blog 2", "This is my testing blog");
            blog2.setAuthor(Author.findById(1L));
            blog1.setAuthor(Author.findById(2L));
            blogService.addBlog(blog1);
            blogService.addBlog(blog2);
        }

    }
}