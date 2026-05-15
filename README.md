
# 💸 Projet FlashCash - Application de Transfert d'Argent

### 📝 Description
FlashCash est une application web sécurisée développée avec **Spring Boot**. Elle permet aux utilisateurs de gérer un compte virtuel et d'effectuer des transferts d'argent entre amis en temps réel, avec une gestion automatisée des commissions.

---

### 🛠️ Environnement Technique
* **Backend :** Java 17, Spring Boot 3.x, Spring Security (BCrypt)
* **Frontend :** HTML5, CSS3, JavaScript (Fetch API / Async-Await), Thymeleaf
* **Base de données :** MySQL 8.0
* **Gestion de dépendances :** Maven
* **Conteneurisation :** Docker / Docker-Compose

---

### 🚀 Installation et Lancement

#### 1. Prérequis
* JDK 17 installé
* Maven installé
* Docker Desktop (optionnel pour le déploiement conteneurisé)

#### 2. Configuration (.env)
Créez un fichier `.env` à la racine du projet (ou modifiez `application.properties`) :
```properties
DB_URL=jdbc:mysql://localhost:3306/flashcash
DB_USERNAME=votre_user
DB_PASSWORD=votre_password



