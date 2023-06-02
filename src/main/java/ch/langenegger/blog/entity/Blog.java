package ch.langenegger.blog.entity;

import ch.langenegger.blog.author.entity.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
