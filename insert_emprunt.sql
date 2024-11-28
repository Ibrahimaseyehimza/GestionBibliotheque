BEGIN;

-- Vérifier la disponibilité de l'article
SELECT disponibilite FROM articles WHERE id = ?;

-- Récupérer l'ID du compte du membre
SELECT id FROM comptes WHERE membre_id = ?;

-- Insérer un enregistrement dans la table 'emprunts'
INSERT INTO emprunts (compte_id, article_id, date_emprunt, date_retour, amende)
VALUES (?, ?, CURRENT_DATE, NULL, 0.0);

-- Mettre à jour la disponibilité de l'article
UPDATE articles SET disponibilite = false WHERE id = ?;

-- Mettre à jour le nombre d'emprunts en cours du membre
UPDATE comptes SET emprunts_en_cours = emprunts_en_cours + 1 WHERE membre_id = ?;

COMMIT;
