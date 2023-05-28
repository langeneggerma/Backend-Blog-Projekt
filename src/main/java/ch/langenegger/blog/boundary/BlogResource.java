package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.BlogRepository;
import ch.langenegger.blog.entity.Blog;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/blog")
public class BlogResource {

    @Inject
    BlogRepository blogRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> getBlogs(){
        return blogRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Blog getBlog(@RestPath("id") Long id) {
        return blogRepository.findById(id);
    }
}


