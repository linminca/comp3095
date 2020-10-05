package ca.gbc.comp3095.lecture2.controllers;

import ca.gbc.comp3095.lecture2.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public  String getAuthors(Model model){

        //add attribute to scope, to be later view in subsequent view
        model.addAttribute("authors", authorRepository.findAll());

        //return path to location of next view to render result
        return "authors/list";
    }




}
