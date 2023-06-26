package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.AuthorService;
import ch.langenegger.blog.dto.AuthorRequest;
import ch.langenegger.blog.entity.Author;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/author")
@Tag(name="Author")
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Author getAuthor(Long id) {
        return authorService.getAuthor(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({ @APIResponse(responseCode = "201", description = "Successful") })
    @RequestBody(description = "The Author to create", required = true, content = @Content(schema = @Schema(implementation = AuthorRequest.class)))
    public void addAuthor( Author author) {
        authorService.addAuthor(author);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deleteAuthor(Long id) {
        Author author = authorService.getAuthor(id);
        authorService.deleteAuthor(author);
    }
}
