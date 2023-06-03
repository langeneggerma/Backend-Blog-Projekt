package ch.langenegger.blog;

import ch.langenegger.blog.control.AuthorService;
import ch.langenegger.blog.control.BlogService;
import ch.langenegger.blog.entity.Blog;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BlogServiceTest {
    @Inject
    BlogService blogService;
    @Inject
    AuthorService authorService;

    @Test
    void listingAndAddingBlogs() {
        // Arrange
        Blog blog = new Blog("Testing Blog", "This is my testing blog", authorService.getAuthor(1L));
        Blog blog2 = new Blog("Testing Blog 2", "This is my testing blog", authorService.getAuthor(2L));
        int blogsBefore;
        List<Blog> blogs;

        // Act
        blogsBefore = blogService.getBlogs().size();
        blogService.addBlog(blog);
        blogService.addBlog(blog2);
        blogs = blogService.getBlogs();

        // Assert
        assertEquals(blogsBefore + 2, blogs.size());
        assertEquals(blog.getTitle(), blogs.get(blogs.size() - 2).getTitle());
    }
}