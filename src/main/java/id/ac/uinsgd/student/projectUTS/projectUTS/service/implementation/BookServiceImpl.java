package id.ac.uinsgd.student.projectUTS.projectUTS.service.implementation;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.Book;
import id.ac.uinsgd.student.projectUTS.projectUTS.repository.BookRepository;
import id.ac.uinsgd.student.projectUTS.projectUTS.service.framework.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    @Override
    public Book save(Book std) {
        return bookRepository.save(std);
    }

    @Override
    public void deleteById(Long id)  {
        bookRepository.deleteById(id);
    }
}
