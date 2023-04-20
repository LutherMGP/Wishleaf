package com.martingrosen.wish;

import jakarta.persistence.*;

    /* Samlet set er denne klasse designet til at repræsentere en enkelt post i en ønskeliste og gemme denne post i en
    database ved hjælp af JPA. Klassen giver også mulighed for at få og ændre værdierne for postens navn, beskrivelse
    og link ved hjælp af getter- og setter-metoder. */

@Entity
@Table(name = "wishes")
public class Wish {

    /* Når strategien GenerationType.IDENTITY anvendes, er databasesystemet ansvarligt for at generere primær nøgleværdierne.
    JPA-leverandøren indsætter entiteten i databasen og henter den genererede ID-værdi fra databasen.
    Denne værdi tildeles derefter til primær nøgleattributten i entitetsobjektet.
    'id' -kolonnen er en heltalsværdi, som er den primære nøgle i tabellen. Denne kolonne er også auto-genereret af databasen.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* @Column-annotationen bruges til at specificere egenskaberne for hver kolonne i wishes-tabellen, som følger: */

    /* 'name'-kolonnen er en streng med en maksimal længde på 45 tegn og kan ikke indeholde null-værdier.*/
    @Column(length = 45, nullable = false)
    private String name;

    /* 'description' -kolonnen er en streng med en maksimal længde på 200 tegn og kan indeholde null-værdier. */
    @Column(length = 200)
    private String description;

    /* 'link' -kolonnen er en streng med en maksimal længde på 1000 tegn */
    @Column(length = 1000)
    private String link;

    private boolean enabled;

    /* Klassen indeholder også getter- og setter-metoder til at få og ændre værdierne for de private feltvariabler.
    Disse metoder er genereret af IntelliJ's "Encapsulate fields" -funktion, som sikrer, at adgangen til feltvariabler
    bliver kontrolleret og valideret i overensstemmelse med klassens ansvar.*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
