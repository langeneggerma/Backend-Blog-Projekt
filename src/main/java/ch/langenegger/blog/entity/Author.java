package ch.langenegger.blog.entity;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author extends BaseEntity{
    private String firstname;
    private String lastname;
}
