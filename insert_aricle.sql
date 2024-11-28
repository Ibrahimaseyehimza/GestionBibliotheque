-- Insertion d'un Livre dans la table article
INSERT INTO articles (titre, type, auteur, isbn, disponibilite) 
VALUES ('Une si logue lettre', 'Livre', 'Mariama BA', 12234, true);

-- Insertion d'un CD dans la table article
INSERT INTO articles (titre, duree, disponibilite) 
VALUES ('Wakh amatoull', 15, true);

-- Insertion d'un DVD dans la table article
INSERT INTO articles (titre, type, duree, disponibilite) 
VALUES ('Masamba Walo', DVD, 15, true);
