package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    //Create customer address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    address.setOwners(Set.of(customer));

    //Add reference to customer as well
    customer.setAddresses(Set.of(address));


    //Create credit cards
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);

    //Create second credit card
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);

    //Create pincode for both cards
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    //Add pincode property to each card
    creditCard1.setPincode(pincode);
    creditCard2.setPincode(pincode);

    //Add bank
    Bank bank = new Bank();
    bank.setName("Pengebank");
    creditCard1.setOwningBank(bank);
    creditCard2.setOwningBank(bank);

    //Get list of all credit cards of customer
    Set<CreditCard> creditCards = Set.of(creditCard1,creditCard2);

    //Add collection to customer object
    customer.setCreditCards(creditCards);
    bank.setOwnedCards(creditCards);

    em.persist(customer);
    em.persist(address);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
    em.persist(bank);
  }
}
