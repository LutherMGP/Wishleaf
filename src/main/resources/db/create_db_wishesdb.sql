-- *******************************************************************
-- Opretter en database kaldet 'wishesdb' til brug i Wishleaf
-- Husk at tilpasse brugernavn & password i application.properties ;-)
-- *******************************************************************

-- oprettelse af database
CREATE DATABASE IF NOT EXISTS wishesdb;
USE wishesdb;

-- Opretter en tabel kaldet 'wishes'
CREATE TABLE IF NOT EXISTS wishes
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(200),
    link VARCHAR(1000),
    enabled BOOLEAN DEFAULT TRUE
);

-- Indsætter testdata i 'wishes' tabellen
INSERT INTO wishes (name, description, link)
VALUES ('Fred i verden', 'Ønske om global fred', 'https://example.com/fred-i-verden');

-- Indsætter yderligere 19 eksempler på ønsker (wishes)
INSERT INTO wishes (name, description, link)
VALUES ('Ønske 2', 'Beskrivelse af ønske 2', 'https://example.com/wish2'),
       ('Ønske 3', 'Beskrivelse af ønske 3', 'https://example.com/wish3'),
       ('Ønske 4', 'Beskrivelse af ønske 4', 'https://example.com/wish4'),
       ('Ønske 5', 'Beskrivelse af ønske 5', 'https://example.com/wish5'),
       ('Ønske 6', 'Beskrivelse af ønske 6', 'https://example.com/wish6'),
       ('Ønske 7', 'Beskrivelse af ønske 7', 'https://example.com/wish7'),
       ('Ønske 8', 'Beskrivelse af ønske 8', 'https://example.com/wish8'),
       ('Ønske 9', 'Beskrivelse af ønske 9', 'https://example.com/wish9'),
       ('Ønske 10', 'Beskrivelse af ønske 10', 'https://example.com/wish10'),
       ('Ønske 11', 'Beskrivelse af ønske 11', 'https://example.com/wish11'),
       ('Ønske 12', 'Beskrivelse af ønske 12', 'https://example.com/wish12'),
       ('Ønske 13', 'Beskrivelse af ønske 13', 'https://example.com/wish13'),
       ('Ønske 14', 'Beskrivelse af ønske 14', 'https://example.com/wish14'),
       ('Ønske 15', 'Beskrivelse af ønske 15', 'https://example.com/wish15'),
       ('Ønske 16', 'Beskrivelse af ønske 16', 'https://example.com/wish16'),
       ('Ønske 17', 'Beskrivelse af ønske 17', 'https://example.com/wish17'),
       ('Ønske 18', 'Beskrivelse af ønske 18', 'https://example.com/wish18'),
       ('Ønske 19', 'Beskrivelse af ønske 19', 'https://example.com/wish19'),
       ('Ønske 20', 'Beskrivelse af ønske 20', 'https://example.com/wish20');