package ch.langenegger.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
