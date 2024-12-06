
```markdown
## Application CRUD de Gestion de Budget

Cette application permet de gérer un budget personnel en utilisant une interface web. Elle permet d'ajouter, de modifier, de supprimer et de consulter des transactions (revenus et dépenses) en temps réel. Le backend est développé en Java avec Spring Boot, le frontend en React, et les données sont stockées dans une base de données PostgreSQL. Le design de l'application utilise TailwindCSS.

## Technologies utilisées

- **Backend** : Spring Boot (Java)
- **Frontend** : React.js
- **Base de données** : PostgreSQL
- **CSS** : TailwindCSS
- **API** : RESTful API avec Spring Boot
- **ORM** : Spring Data JPA

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/install.html)
- [Node.js et npm](https://nodejs.org/en/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/)

## Étapes pour démarrer l'application

### 1. Démarrer le Backend (Spring Boot)

#### a. Cloner le projet

Clonez le repository sur votre machine locale :

```bash
git clone https://github.com/votre-utilisateur/votre-repository.git
cd votre-repository
```

#### b. Configurer la base de données

Avant de démarrer le backend, assurez-vous que PostgreSQL est installé et en cours d'exécution.

1. Créez une nouvelle base de données dans PostgreSQL (par exemple, `budget_db`).
   
   ```sql
   CREATE DATABASE budget_db;
   ```

2. Configurez les paramètres de la base de données dans le fichier `application.properties` ou `application.yml` situé dans le répertoire `src/main/resources/` de votre projet backend :

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/budget_db
   spring.datasource.username= "votre username"
   spring.datasource.password="votre mot de passe"
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

#### c. Lancer l'application backend

Dans le répertoire du backend (assurez-vous d'être dans le répertoire `backend/`), exécutez la commande suivante pour démarrer le serveur Spring Boot :

```bash
mvn spring-boot:run
```

Cela lancera le serveur Spring Boot à l'adresse [http://localhost:9000], où vous pourrez interagir avec l'API REST.

### 2. Démarrer le Frontend (React)

#### a. Installer les dépendances

Dans le répertoire `frontend/`, installez les dépendances nécessaires pour React et TailwindCSS :

```bash
cd frontend
npm install
```

#### b. Configurer l'API backend

Dans le fichier `src/services/api.js` ou tout autre fichier de configuration API, configurez l'URL de votre backend Spring Boot (assurez-vous qu'elle pointe vers [http://localhost:9000]) :

```javascript
const API_URL = "http://localhost:9000/transactions";
```

#### c. Démarrer l'application frontend

Lancez le serveur de développement React avec la commande suivante :

```bash
npm start
```

Cela lancera l'application React sur [http://localhost:3000](http://localhost:3000).

### 3. Accéder à l'application

Une fois que les deux serveurs (backend et frontend) sont en cours d'exécution, ouvrez votre navigateur et allez à l'adresse suivante : [http://localhost:3000] pour accéder à l'interface utilisateur de gestion de budget.

## Fonctionnalités

L'application permet les opérations suivantes :

- **Ajouter une transaction** : Enregistrer un revenu ou une dépense avec la description, le montant, et la date.
- **Modifier une transaction** : Modifier les détails d'une transaction existante.
- **Supprimer une transaction** : Supprimer une transaction de la liste.
- **Visualiser le solde total** : Le solde est calculé en fonction des transactions ajoutées et supprimées.


## Dépendances

### Backend (Spring Boot)

Le fichier `pom.xml` contient les dépendances suivantes :

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

### Frontend (React)

Le fichier `package.json` contient les dépendances suivantes :

```json
{
  "dependencies": {
    "@testing-library/jest-dom": "^5.17.0",
    "@testing-library/react": "^13.4.0",
    "@testing-library/user-event": "^13.5.0",
    "ajv": "^8.17.1",
    "axios": "^1.7.9",
    "react": "^19.0.0",
    "react-dom": "^19.0.0",
    "react-router-dom": "^7.0.2",
    "react-scripts": "5.0.1",
    "web-vitals": "^2.1.4"
  }
}
```

### TailwindCSS Configuration

Assurez-vous d'avoir configuré TailwindCSS en suivant la procédure officielle :

```bash
npx tailwindcss init
```

Ajoutez les configurations dans le fichier `tailwind.config.js` comme suit :

```javascript
module.exports = {
  content: ["./src/**/*.{html,js,jsx,ts,tsx}"],
  theme: {
    extend: {},
  },
  plugins: [],
}
```