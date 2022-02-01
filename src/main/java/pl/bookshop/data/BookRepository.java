package pl.bookshop.data;

import org.springframework.data.repository.CrudRepository;
import pl.bookshop.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
