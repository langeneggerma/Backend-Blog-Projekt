package ch.langenegger.author.control;

import ch.langenegger.author.entity.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository  implements PanacheRepository<Author> {
}
