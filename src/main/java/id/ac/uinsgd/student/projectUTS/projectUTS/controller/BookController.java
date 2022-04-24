package id.ac.uinsgd.student.projectUTS.projectUTS.controller;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.Book;
import id.ac.uinsgd.student.projectUTS.projectUTS.exception.BookNotFoundException;
import id.ac.uinsgd.student.projectUTS.projectUTS.service.framework.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService booksService) {
        this.bookService = booksService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable("id") @Min(1) Long id) {
        Book std = bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Book with "+ id + " is Not Found!!"));
        return std;
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book std) {
        return bookService.save(std);
    }

    @PutMapping(value = "/{id}")
    public Book updateBook(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Book newStd) {
        Book book = bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Book with  " + id + "is Not Found!!"));
        book.setBookName(newStd.getBookName());
        book.setAuthorName(newStd.getAuthorName());
        book.setYear(newStd.getYear());
        book.setPublisher(newStd.getPublisher());
        book.setGenre(newStd.getGenre());
        book.setDateIn(newStd.getDateIn());
        return bookService.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBook(@PathVariable("id") @Min(1) Long id) {
        Book std = bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Book with " + id + " is Not FOund!!"));
        bookService.deleteById(std.getId());
        return "Book with ID : " + id + " is Deleted!";
    }

}
