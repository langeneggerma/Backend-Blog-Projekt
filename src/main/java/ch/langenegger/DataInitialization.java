package ch.langenegger;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {
    @Inject
    BlogService blogService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data only if there is no Data around
        if(Blog.count() < 1) {
            blogService.addBlog(new Blog("Init Test Blog", "This is my testing blog"));
            blogService.addBlog(new Blog("Init Test Blog 2", "This is my testing blog"));
        }
    }
}