package ca.gbc.comp3095.lecture2.controllers;

import ca.gbc.comp3095.lecture2.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllers {

    //inject book repository
    private final BookRepository bookRepository;

    //spring managed controller --> Spring will instantiate controller and inject bookrepository
    public BookControllers(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        //look for list template in book directory under resources (resources/templates/books/list)
        return "books/list";
    }


}
