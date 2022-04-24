package id.ac.uinsgd.student.projectUTS.projectUTS.service.framework;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> findById(Long id);

    Optional<Book> findByBookName(String bookName);

    Book save(Book std);

    void deleteById(Long id);
}
