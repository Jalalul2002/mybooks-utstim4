package id.ac.uinsgd.student.projectUTS.projectUTS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Book Name is Required")
    @NotNull(message = "Book Name can't be Null!")
    @Column(name = "bookName", nullable = false)
    private String bookName;

    @NotEmpty(message = "Author Name is Required")
    @NotNull(message = "Author Name can't be Null!")
    @Column(name = "authorName", nullable = false)
    private String authorName;

    @NotEmpty(message = "Year is Required")
    @NotNull(message = "Year Name can't be Null!")
    @Column(name = "year", nullable = false)
    private String year;

    @NotEmpty(message = "Publisher is Required")
    @NotNull(message = "Publisher can't be Null!")
    @Column(name = "publisher", nullable = false)
    private String publisher;

    @NotEmpty(message = "Genre is Required")
    @NotNull(message = "Genre can't be Null!")
    @Column(name = "genre", nullable = false)
    private String genre;

    @NotNull(message = "Date in can't be Null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateIn;
}
