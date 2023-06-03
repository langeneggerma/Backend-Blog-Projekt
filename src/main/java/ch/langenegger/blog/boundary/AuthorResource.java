package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.AuthorService;
import ch.langenegger.blog.entity.Author;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/author")
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GET
    @Path("/{id}")
    public Author getAuthor(Long id) {
        return authorService.getAuthor(id);
    }


    @POST
    public void addAuthor(Author author) {
        authorService.addAuthor(author);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(Long id) {
        Author author = authorService.getAuthor(id);
        authorService.deleteAuthor(author);
    }
}
