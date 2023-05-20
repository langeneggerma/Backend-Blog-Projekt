package ch.langenegger;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog extends PanacheEntity {
    private Long id;
    public String title;
    private String content;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
