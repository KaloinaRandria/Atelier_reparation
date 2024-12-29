CREATE TABLE client(
   id_client SERIAL,
   mail VARCHAR(255)  NOT NULL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255) ,
   PRIMARY KEY(id_client),
   UNIQUE(mail)
);

CREATE TABLE specialite(
   id_specialite SERIAL,
   libelle VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_specialite)
);

CREATE TABLE marque(
   id_marque SERIAL,
   libelle VARCHAR(255) ,
   PRIMARY KEY(id_marque)
);

CREATE TABLE modele(
   id_modele SERIAL,
   libelle VARCHAR(255) ,
   id_marque INTEGER NOT NULL,
   PRIMARY KEY(id_modele),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque)
);

CREATE TABLE ordinateur(
   id_ordinateur SERIAL,
   num_serie VARCHAR(255)  NOT NULL,
   id_modele INTEGER NOT NULL,
   id_client INTEGER NOT NULL,
   PRIMARY KEY(id_ordinateur),
   UNIQUE(num_serie),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele),
   FOREIGN KEY(id_client) REFERENCES client(id_client)
);

CREATE TABLE technicien(
   id_technicien SERIAL,
   nom VARCHAR(255)  NOT NULL,
   prenom VARCHAR(255) ,
   mail VARCHAR(255)  NOT NULL,
   id_specialite INTEGER NOT NULL,
   PRIMARY KEY(id_technicien),
   UNIQUE(mail),
   FOREIGN KEY(id_specialite) REFERENCES specialite(id_specialite)
);
