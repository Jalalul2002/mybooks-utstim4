package id.ac.uinsgd.student.projectUTS.projectUTS.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1l;
    private String message;

    public BookNotFoundException(String message) {
        this.message = message;
    }
}
