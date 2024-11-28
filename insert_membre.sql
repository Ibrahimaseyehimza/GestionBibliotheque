--Insertion de membre dans la table membre
INSERT INTO membres (prenom, nom, adresse, telephone, email)
VALUES ('mouhamed', 'fall', 'ronkh', '73777377', 'fallameth@gmail.com');
--Création de compte 
INSERT INTO comptes (membre_id, date_creation, emprunts_en_cours)
VALUES (2, CURRENT_DATE, 0);