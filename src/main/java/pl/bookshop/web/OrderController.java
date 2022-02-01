package pl.bookshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bookshop.Book;
import pl.bookshop.Order;
import pl.bookshop.data.OrderRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "";
    }

    @PostMapping
    public String saveOrder(@Valid @ModelAttribute("book") Book book, Errors errors) {
        if(errors.hasErrors()) {
            return "";
        }
        return "redirect:/";
    }

}
