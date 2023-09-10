package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private Integer number;

    @Getter
    @Setter
    private Integer balance;

    @Getter
    @Setter
    private Integer creditLimit;

    @Getter
    @Setter
    @ManyToOne
    private Pincode pincode;

    @Getter
    @Setter
    @ManyToOne
    private Bank owningBank;
}
