package pl.bookshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bookshop.Book;
import pl.bookshop.data.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepo;

    @Autowired
    public HomeController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "home";
    }
}
