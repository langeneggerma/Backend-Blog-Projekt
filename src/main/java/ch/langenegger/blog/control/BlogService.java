package ch.langenegger.blog.control;

import ch.langenegger.blog.entity.Blog;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    public List<Blog> findBlogs(String searchString) {
        var blogs = blogRepository.find("title like ?1 or content like ?1", "%" + searchString + "%");
        logger.info("Returning " + blogs.count() + " blogs");
        return blogs.list();
    }

    public Optional<Blog> getBlog(Long id) {
        logger.info("Getting blog " + id);
        return blogRepository.findByIdOptional(id);
    }

    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public void deleteBlog(Blog blog) {
        logger.info("Deleting blog " + blog.getTitle());
        blogRepository.delete(blog);
    }

    public long count(){
        logger.info("Counting blogs");
        return blogRepository.count();
    }

    @Transactional
    public void updateBlog(Blog blogToUpdate) {
        blogRepository.persist(blogToUpdate);
    }
}