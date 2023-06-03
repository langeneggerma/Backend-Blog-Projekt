package ch.langenegger.blog.control;

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
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    public Blog getBlog(Long id) {
        logger.info("Getting blog " + id);
        return blogRepository.findById(id);
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

}