package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.BlogService;
import ch.langenegger.blog.entity.Blog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("blog")
@ApplicationScoped
public class BlogResource {
    @Inject
    BlogService blogService;

    @GET // Diese Methode wird aufgerufen Get-Methode aufgerufen
    public List<Blog> getEntries(){
        return blogService.getBlogs();
    }
    @GET
    @Path("{id}")
    public Blog getBlog(Long id){
        return blogService.getBlog(id);
    }

    @GET
    @Path("count")
    public long count(){
        return blogService.count();
    }

    @POST // Diese Methode wird aufgerufen Post-Methode aufgerufen
    public void addBlog(Blog blog) {
        this.blogService.addBlog(blog);
    }
    @DELETE
    @Path("{id}")
    public void deleteBlog(Long id) {
        Blog blog = this.blogService.getBlog(id);
        this.blogService.deleteBlog(blog);
    }

}


