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
