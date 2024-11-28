-- Créer la table pour les articles
CREATE TABLE articles (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255),
    type VARCHAR(50),
    auteur VARCHAR(255),
    isbn INT,
    duree INT,
    disponibilite BOOLEAN
);

-- Créer la table pour les membres
CREATE TABLE membres (
    id SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour l'auto-incrémentation
    prenom VARCHAR(255),
    nom VARCHAR(255),
    adresse VARCHAR(255),
    telephone VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Créer la table pour les comptes
CREATE TABLE comptes (
    id SERIAL PRIMARY KEY,  -- Id du compte
    membre_id INT,  -- ID du membre (clé étrangère)
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Date de création du compte
    emprunts_en_cours INT DEFAULT 0,  -- Emprunts en cours
    FOREIGN KEY (membre_id) REFERENCES membres(id) ON DELETE CASCADE
);

-- Créer la table pour les emprunts
CREATE TABLE emprunts (
    id SERIAL PRIMARY KEY,
    compte_id INT REFERENCES comptes(id),
    article_id INT REFERENCES articles(id),
    date_emprunt DATE,
    date_retour DATE,
    amende FLOAT
);
