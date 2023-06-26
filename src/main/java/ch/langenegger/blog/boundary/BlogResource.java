package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.BlogService;
import ch.langenegger.blog.dto.BlogRequest;
import ch.langenegger.blog.entity.Blog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("blog")
@Tag(name="Blogs")
@ApplicationScoped
public class BlogResource {
    @Inject
    BlogService blogService;

    @Inject
    Logger logger;


    @GET // Diese Methode wird aufgerufen Get-Methode aufgerufen
    public List<Blog> getEntries(@QueryParam("search") String search) {
        if(search != null && !search.isBlank()){
            return blogService.findBlogs(search);
        }
        return blogService.getBlogs();
    }
    @GET
    @Path("{id}")
    public Blog getBlog(Long id){
      return blogService.getBlog(id).orElseThrow(()-> new NotFoundException("Blog mit id " + id + " nicht gefunden"));
    }

//    @PUT
//    @Path("{id}")
//    public void updateBlog(Long id, Blog blog){
//        var blogToUpdate = blogService.getBlog(id).orElseThrow(()-> new NotFoundException("Blog mit id " + id + " nicht gefunden und kann nicht aktualisiert werden"));
//        blogToUpdate.setTitle(blog.getTitle());
//        blogToUpdate.setContent(blog.getContent());
//        blogService.updateBlog(blogToUpdate);
//    }

    @GET
    @Path("count")
    public long count(){
        return blogService.count();
    }

    @POST // Diese Methode wird aufgerufen Post-Methode aufgerufen
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({ @APIResponse(responseCode = "201", description = "Successful") })
    @RequestBody(description = "Add new Blog-Post", required = true, content = @Content(schema = @Schema(implementation = BlogRequest.class)))
    public Response addBlog(Blog blog, @Context UriInfo uriInfo) {
        this.blogService.addBlog(blog);
        var uri = uriInfo.getAbsolutePathBuilder().path(blog.getId().toString()).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteBlog(Long id) {
        var blog =  blogService.getBlog(id).orElseThrow(()-> new NotFoundException("Blog mit id " + id + " nicht gefunden und kann nicht gelöscht werden"));
        this.blogService.deleteBlog(blog);
    }

}


