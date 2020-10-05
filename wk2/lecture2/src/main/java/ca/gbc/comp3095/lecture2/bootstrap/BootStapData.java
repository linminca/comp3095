package ca.gbc.comp3095.lecture2.bootstrap;

import ca.gbc.comp3095.lecture2.domain.Author;
import ca.gbc.comp3095.lecture2.domain.Book;
import ca.gbc.comp3095.lecture2.repositories.AuthorRepository;
import ca.gbc.comp3095.lecture2.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //create an author
        Author eric = new Author("eric", "Evans");

        //create book, set publisher
        Book ddd = new Book("Domain Driven Design", "123123");

        //add book to author
        eric.getBooks().add(ddd);
        //add author to book
        ddd.getAuthors().add(eric);
        //add book to publisher

        //save both objects (eric and ddd) to H2 database;
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //create an author and book
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");

        //add book to author
        rod.getBooks().add(noEJB);
        //add author to book
        noEJB.getAuthors().add(rod);

        //save both objects (eric and ddd) to H2 database;
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        //sout --> shortcut
        System.out.println("Started in Bootstrap...");
        System.out.println("Number of Books " + bookRepository.count());


    }


}
