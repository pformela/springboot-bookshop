package pl.bookshop.data;

import org.springframework.data.repository.CrudRepository;
import pl.bookshop.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
