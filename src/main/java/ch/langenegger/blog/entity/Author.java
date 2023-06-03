package ch.langenegger.blog.entity;

import jakarta.persistence.Entity;
import lombok.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor()
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{
    private String firstname;
    private String lastname;
}
