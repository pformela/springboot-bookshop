package pl.bookshop.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.bookshop.Book;
import pl.bookshop.data.BookRepository;

import javax.persistence.Query;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/update")
public class UpdateBookController {

    private BookRepository bookRepo;

    @Autowired
    public UpdateBookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/{id}")
    public String showBookToUpdate(@PathVariable("id") long book_id, Model model) {
        if(!bookRepo.existsById(book_id)) {
            model.addAttribute("book_id", book_id);
            return "bookNotFound";
        }
        model.addAttribute("book_id", book_id);
        model.addAttribute("book", bookRepo.findById(book_id));
        return "updateBook";
    }

    @PostMapping("/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                             @PathVariable("id") long book_id,
                             Errors errors,
                             Model model) {
        if (errors.hasErrors()) {
            return "updateBook";
        }

        log.info("Id: " + book_id);
        Book updated_book = bookRepo.findById(book_id).get();
        updated_book.setTitle(book.getTitle());
        updated_book.setAuthor(book.getAuthor());
        updated_book.setRelease_date(book.getRelease_date());
        updated_book.setDescription(book.getDescription());

        bookRepo.save(updated_book);
        return "redirect:/";
    }

}
