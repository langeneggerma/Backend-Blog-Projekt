package ch.langenegger.author.boundary;

import ch.langenegger.author.control.AuthorRepository;
import ch.langenegger.author.entity.Author;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/author")
public class AuthorResource {

    @Inject
    AuthorRepository authorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Author getAuthor(@RestPath("id") Long id) {
        return authorRepository.findById(id);
    }
}
