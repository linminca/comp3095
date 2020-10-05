package ca.gbc.comp3095.lecture2.repositories;

import ca.gbc.comp3095.lecture2.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {




}
