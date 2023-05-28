package ch.langenegger.blog.boundary;

import ch.langenegger.author.control.AuthorRepository;
import ch.langenegger.blog.control.BlogRepository;
import ch.langenegger.blog.entity.Blog;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    AuthorRepository authorRepository;

    @Inject
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }
    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }
}