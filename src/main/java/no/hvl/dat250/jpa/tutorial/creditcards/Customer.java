package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @OneToMany
    @Getter
    @Setter
    private Collection<Address> Addresses = new ArrayList<>();

    @OneToMany
    @Getter
    @Setter
    private Collection<CreditCard> CreditCards = new ArrayList<>();
}
