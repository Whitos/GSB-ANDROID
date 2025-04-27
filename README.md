
# GSB Visites - Projet Mobile & API

Projet complet de gestion de visites médicales pour le laboratoire Galaxy Swiss Bourdin, comprenant :
- Une **application Android** pour les visiteurs médicaux.
- Une **API REST** réalisée en **Node.js/ExpressJS** pour la communication serveur.

---

## 📱 Partie 1 : Application Android (GSB-ANDROID)

### Fonctionnalités principales

- Authentification utilisateur (connexion sécurisée)
- Consultation de la liste des praticiens associés
- Consultation des visites d'un praticien
- Ajout d'un nouveau praticien
- Création et mise à jour de visites
- Appels aux API REST avec traitement des réponses JSON

### Technologies utilisées

- **Android Studio**
- **Java**
- **Appels API REST (HTTPClient/Volley/Retrofit)**
- Gestion de la persistance temporaire des données en local

---

## 🌐 Partie 2 : API Backend (API-GSB-Visite)

### Fonctionnalités principales

- Authentification des visiteurs
- Récupération des praticiens associés à un visiteur
- Récupération, création et modification des visites
- Création de nouveaux praticiens
- API sécurisée avec contrôle des accès

### Technologies utilisées

- **Node.js** + **ExpressJS** (serveur backend)
- **MongoDB** (base de données NoSQL)
- **Mongoose** (ORM pour MongoDB)
- **Postman** (tests d'API)

### Routes principales

| Méthode | URL | Description |
|:---|:---|:---|
| POST | `/api/auth/login` | Authentification utilisateur |
| GET | `/api/praticiens` | Liste des praticiens associés |
| GET | `/api/visites` | Liste des visites par praticien |
| POST | `/api/praticiens` | Création d'un nouveau praticien |
| POST | `/api/visites` | Création d'une nouvelle visite |
| PUT | `/api/visites/:id` | Mise à jour d'une visite existante |

---

## 🗂️ Architecture générale

```
/GSB-ANDROID
├── Activities
├── Models
├── Services (appels API)
├── Adapters
├── Layouts (XML)

+ 

/API-GSB-Visite
├── app.js (serveur Express)
├── routes/
│   ├── auth.js
│   ├── praticiens.js
│   ├── visites.js
├── models/
│   ├── Praticien.js
│   ├── Visite.js
│   ├── User.js
├── controllers/
├── config/
```

---

## 🚀 Déploiement rapide

### Lancer l'API (backend)

1. Cloner le projet backend :
```bash
git clone https://github.com/Whitos/API-GSB-Visite.git
```
2. Installer les dépendances :
```bash
npm install
```
3. Lancer le serveur :
```bash
npm start
```
4. L'API tourne sur `http://localhost:3000/`

### Lancer l'application Android

1. Cloner le projet Android :
```bash
git clone https://github.com/Whitos/GSB-ANDROID.git
```
2. Ouvrir avec Android Studio.
3. Modifier l'URL du serveur backend si nécessaire dans les fichiers de configuration réseau.
4. Lancer l'application sur un émulateur ou un appareil physique.

---

## 📄 Cahier des charges résumé

- Application Android native pour visiteurs médicaux.
- Gestion complète des praticiens et visites.
- Communication en REST API.
- Fonctionnement sécurisé et structuré.
- Base de données MongoDB.
- Tests API réalisés avec Postman.

---

## 🔗 Liens utiles

- [Repo Android App](https://github.com/Whitos/GSB-ANDROID)
- [Repo API Backend](https://github.com/Whitos/API-GSB-Visite)

---
