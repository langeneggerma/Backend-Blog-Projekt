package ch.langenegger.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor()
@EqualsAndHashCode(callSuper = true)
public class Blog  extends BaseEntity{
    public String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
