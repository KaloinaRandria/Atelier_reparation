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

CREATE TABLE Mvt_stock(
   id_mvt_stock SERIAL,
   libelle VARCHAR(255) ,
   date_mvt DATE NOT NULL,
   PRIMARY KEY(id_mvt_stock)
);

CREATE TABLE composant(
   id_composant SERIAL,
   libelle VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_composant)
);

CREATE TABLE type_ordinateur(
   id_type_ordinateur SERIAL,
   libelle VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_type_ordinateur)
);

CREATE TABLE type_reparation(
   id_type_reparation SERIAL,
   libelle VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id_type_reparation)
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

CREATE TABLE ordinateur(
   id_ordinateur SERIAL,
   num_serie VARCHAR(255)  NOT NULL,
   id_type_ordinateur INTEGER NOT NULL,
   id_modele INTEGER NOT NULL,
   id_client INTEGER NOT NULL,
   PRIMARY KEY(id_ordinateur),
   UNIQUE(num_serie),
   FOREIGN KEY(id_type_ordinateur) REFERENCES type_ordinateur(id_type_ordinateur),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele),
   FOREIGN KEY(id_client) REFERENCES client(id_client)
);

CREATE TABLE reparation(
   id_reparation SERIAL,
   desc_probleme VARCHAR(255)  NOT NULL,
   date_depot DATE NOT NULL,
   date_retrait DATE,
   cout_reparation NUMERIC(15,2)   NOT NULL,
   id_type_reparation INTEGER NOT NULL,
   id_composant INTEGER NOT NULL,
   id_technicien INTEGER NOT NULL,
   id_ordinateur INTEGER NOT NULL,
   PRIMARY KEY(id_reparation),
   FOREIGN KEY(id_type_reparation) REFERENCES type_reparation(id_type_reparation),
   FOREIGN KEY(id_composant) REFERENCES composant(id_composant),
   FOREIGN KEY(id_technicien) REFERENCES technicien(id_technicien),
   FOREIGN KEY(id_ordinateur) REFERENCES ordinateur(id_ordinateur)
);

CREATE TABLE Mvt_stock_fille(
   id_mvt_stock_fille SERIAL,
   entree INTEGER,
   sortie INTEGER,
   id_ordinateur INTEGER NOT NULL,
   id_mvt_stock INTEGER NOT NULL,
   PRIMARY KEY(id_mvt_stock_fille),
   FOREIGN KEY(id_ordinateur) REFERENCES ordinateur(id_ordinateur),
   FOREIGN KEY(id_mvt_stock) REFERENCES Mvt_stock(id_mvt_stock)
);
