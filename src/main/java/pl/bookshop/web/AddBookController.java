package pl.bookshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bookshop.Book;
import pl.bookshop.data.BookRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AddBookController {

    private final BookRepository bookRepo;

    @Autowired
    public AddBookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @ModelAttribute("book")
    public Book book() {
        return new Book();
    }

    @GetMapping
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping
    public String processBook(@Valid @ModelAttribute("book") Book book, Errors errors) {
        if (errors.hasErrors()) {
            return "addBook";
        }

        bookRepo.save(book);
        return "redirect:/";
    }


}
