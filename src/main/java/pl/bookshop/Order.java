package pl.bookshop;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min=2, max=30, message="Pole imię powinno mieć długość od 2 do 30 znaków")
    private String name;

    @Size(min=2, max=30, message="Pole nazwisko powinno mieć długość od 2 do 30 znaków")
    private String surname;

    @Size(min=9, max=12, message="Pole numer telefonu powinno mieć długość od 9 do 12 znaków")
    private String telephone;

    @Size(min=5, max=30, message="Pole adres e-mail powinno mieć długość od 5 do 30 znaków")
    private String email;

    @Size(min=2, max=30, message="Pole ulica powinno mieć długość od 2 do 30 znaków")
    private String street;

    @Size(min=2, max=30, message="Pole miasto powinno mieć długość od 2 do 30 znaków")
    private String city;

    @Size(min=6, max=6, message="Pole kod pocztowy powinno mieć długość 6 znaków")
    private String postal_code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
