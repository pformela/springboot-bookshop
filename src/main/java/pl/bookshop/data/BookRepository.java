package pl.bookshop.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import pl.bookshop.Book;

import javax.persistence.Query;

public interface BookRepository extends CrudRepository<Book, Long> {
}
