package ch.langenegger.blog.control;

import ch.langenegger.blog.entity.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository  implements PanacheRepository<Author> {
}
