package id.ac.uinsgd.student.projectUTS.projectUTS.controller;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.Book;
import id.ac.uinsgd.student.projectUTS.projectUTS.service.framework.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BookWebController {

    BookService bookService;

    @GetMapping("/tableBooks")
    public String index(Model model){
        model.addAttribute("book", bookService.getAllBooks());
        return "tableBooks";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("book", new Book());
        return "formBook";
    }

    @PostMapping("/create")
    public String addBook (Model model, Book book) {
        model.addAttribute("book", bookService.save(book));
        return "redirect:/tableBooks";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "formBook";
    }

    @GetMapping(value = "/delete/{id}")
    public  String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/tableBooks";
    }
}
