package com.martingrosen;

import com.martingrosen.wish.Wish;
import com.martingrosen.wish.WishRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/* Pakkedeklaration */
/*
package com.martingrosen;:
Dette er navnet på pakken, som klassen er en del af.

import com.martingrosen.wish.Wish;:
Dette er en import-sætning, som gør Wish-klassen tilgængelig i WishRepositoryTests.java.

import com.martingrosen.wish.WishRepository;:
Dette er en import-sætning, som gør WishRepository-interfacet tilgængeligt i WishRepositoryTests.java.

import org.assertj.core.api.Assertions;:
Dette er en import-sætning, som gør Assertions-klassen fra AssertJ-biblioteket tilgængelig i WishRepositoryTests.java.

import org.junit.jupiter.api.Test;:
Dette er en import-sætning, som gør @Test-annotationen fra JUnit 5 tilgængelig i WishRepositoryTests.java.

import org.springframework.beans.factory.annotation.Autowired;:
Dette er en import-sætning, som gør @Autowired-annotationen fra Spring Framework tilgængelig i WishRepositoryTests.java.

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;:
Dette er en import-sætning, som gør @AutoConfigureTestDatabase-annotationen fra Spring Boot-testrammen tilgængelig i
WishRepositoryTests.java.

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;:
Dette er en import-sætning, som gør @DataJpaTest-annotationen fra Spring Boot-testrammen tilgængelig i
WishRepositoryTests.java.

import org.springframework.test.annotation.Rollback;:
Dette er en import-sætning, som gør @Rollback-annotationen fra Spring Framework tilgængelig i WishRepositoryTests.java.*/

/* Java klassens ansvar */
/* Java-klassens ansvar:
WishRepositoryTests.java er en Java-klasse, som indeholder forskellige testmetoder til at teste funktionaliteten
i WishRepository, som er en interface, der indeholder metoder til at manipulere data i databasen.
Testklassen bruger JUnit 5 og Spring Boot-testrammen til at teste repository-metoderne.*/

/* Anvendte annotationer*/
/*
@DataJpaTest:
Dette er en annotation, som indikerer, at testklassen vil teste JPA-komponenter i Spring Boot-applikationen.

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE):
Dette er en annotation, som angiver, at den faktiske database skal bruges i stedet for en hukommelsesdatabase til testen.

@Rollback(false):
Dette er en annotation, som angiver, at transaktioner ikke skal rulles tilbage efter hver testmetode.

@Autowired private WishRepository repo;:
Dette er en annotation, som injicerer en instans af WishRepository i testklassen. */

/* CRUD */
/*
@Test public void testAddNew():
Oprettelse (Create).
Dette er en testmetode, som tester save-metoden i WishRepository ved at oprette en ny Wish og gemme den i databasen.
Testen kontrollerer, om den gemte Wish ikke er null og om dens id er større end 0.

@Test public void testListAll():
Læsning (Read).
Dette er en testmetode, som tester findAll-metoden i WishRepository ved at hente alle Wish-objekterne fra databasen og
udskrive dem på konsollen. Testen kontrollerer, om antallet af Wish-objekter i databasen er større end 0.

@Test public void testUpdate():
Opdatering (Update).
Dette er en testmetode, som tester save-metoden i WishRepository ved at opdatere en eksisterende Wish i databasen og
kontrollere, om den opdaterede Wish har den rigtige name-værdi.

@Test public void testGet():
Læsning (Read)
Dette er en testmetode, som tester findById-metoden i WishRepository ved at hente en Wish fra databasen med en bestemt
id og kontrollere, om den hentede Wish ikke er null.

@Test public void testDelete():
Sletning (Delete).
Dette er en testmetode, som tester deleteById-metoden i WishRepository ved at slette en Wish med en bestemt id fra
databasen og kontrollere, om den slettede Wish ikke længere er til stede i databasen.
*/


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class WishRepositoryTests {
    @Autowired private WishRepository repo;


    @Test
    public void testAddNew() {
        Wish wish = new Wish();
        wish.setName("iPhone 15");
        wish.setDescription("Farve: Pink");
        wish.setLink("https://iphone-pink-link");

        Wish savedWish = repo.save(wish);

        Assertions.assertThat(savedWish).isNotNull();
        Assertions.assertThat(savedWish.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Wish> wishes = repo.findAll();
        Assertions.assertThat(wishes).hasSizeGreaterThan(0);

        for (Wish wish : wishes) {
            System.out.println(wish);
        }
    }

    @Test
    public void testUpdate() {
        Integer wishId = 1;
        Optional<Wish> optionalWish = repo.findById(wishId);
        Wish wish = optionalWish.get();
        wish.setName("iPhone 13");
        repo.save(wish);

        Wish updatedWish = repo.findById(wishId).get();
        Assertions.assertThat(updatedWish.getName()).isEqualTo("iPhone 13");
    }

    @Test
    public void testGet() {
        Integer wishId = 3;
        Optional<Wish> optionalWish = repo.findById(wishId);
        Assertions.assertThat(optionalWish).isPresent();
        System.out.println(optionalWish.get());
    }

    @Test
    public void testDelete() {
        Integer wishId = 2;
        repo.deleteById(wishId);

        Optional<Wish> optionalWish = repo.findById(wishId);
        Assertions.assertThat(optionalWish).isNotPresent();
    }
}