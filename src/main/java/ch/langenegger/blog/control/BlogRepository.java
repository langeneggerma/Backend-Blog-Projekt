package ch.langenegger.blog.control;

import ch.langenegger.blog.entity.Blog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogRepository  implements PanacheRepository<Blog> {
}