
# GSB Visites - Application Android

Application mobile Android développée pour le laboratoire Galaxy Swiss Bourdin (GSB) dans le cadre du BTS SIO SLAM.

## 📋 Présentation du projet

L'application **GSB Visites** permet aux visiteurs médicaux de :
- Se connecter de manière sécurisée.
- Consulter la liste de leurs praticiens associés.
- Visualiser et consulter les comptes rendus de visites.
- Créer et mettre à jour des visites.
- Ajouter de nouveaux praticiens.

Cette application s'inscrit dans la démarche de digitalisation de l'activité commerciale du laboratoire et vise à centraliser les comptes-rendus de visite pour un meilleur suivi de la communication auprès des praticiens.

## 🛠️ Fonctionnalités principales

- Authentification (email + mot de passe)
- Liste des praticiens associés
- Détail des informations d'un praticien
- Liste des visites par praticien
- Détail et mise à jour d'une visite
- Création d'un praticien
- Création d'une nouvelle visite
- Fonctionnement hors-ligne avec synchronisation différée (prévu)

## 🧱 Architecture technique

- **Android Studio** pour le développement mobile
- **Java** pour le code source
- **MongoDB** pour le stockage des données (modèle document)
- Respect des conventions de la **programmation orientée objet**

## 🗂️ Schéma de la base de données MongoDB

```
Motif
- _id
- libelle: String

Visiteur
- _id
- nom: String
- prenom: String
- tel: String
- email: String
- date_embauche: Date
- visites: [Visite]

Visite
- _id
- date_visite: Date
- commentaire: String
- visiteur: Visiteur
- praticien: Praticien
- motif: Motif

Praticien
- _id
- nom: String
- prenom: String
- tel: String
- email: String
- rue: String
- code_postal: String
- ville: String
- visites: [Visite]
```

## 📱 Maquettes de l'application

- Connexion utilisateur
- Liste des praticiens
- Informations du praticien et ses visites
- Détail de la visite
- Création d'une nouvelle visite


## 📄 Cahier des charges résumé

- Application simple et ergonomique destinée aux visiteurs médicaux.
- Fonctionnement en mode hors-ligne possible (synchronisation prévue).
- Centralisation des comptes-rendus de visites.
- Mise à disposition d'informations sur les praticiens et les produits.
- Développement natif Android obligatoire.
- Respect de la programmation orientée objet.

## 🚀 Déploiement rapide

1. Cloner le projet Android Studio :
```bash
git clone https://github.com/Whitos/GSBVisites.git
```
2. Ouvrir le projet avec Android Studio.
3. Configurer l'accès à la base MongoDB (si connexion distante prévue).
4. Lancer l'application sur un émulateur ou un appareil Android réel.

## 🔗 Liens utiles

---
