package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Set;

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
    private Set<Address> Addresses;

    @OneToMany
    @Getter
    @Setter
    private Set<CreditCard> CreditCards;
}
