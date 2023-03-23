# questJpa

- Copie le src et le pom.xml dans un nouveau projet Maven - JPA - Hibernate
- Supprime ce qu'il y a dans test/java
- Supprime ce qu'il y a dans main/java
- Modifie l'<artifactId>PROJECT_NAME</artifactId> du pom.xml et vérifie les dépendances
- Dans src/main/resources/META-INF : modifie persistence.xml 
-       <persistence-unit name="PROJECT_NAME">
-       <property name="hibernate.connection.url"
-				value="jdbc:mysql://localhost:3306/DATABASE_NAME" /> avec le nom de ta BDD
- Sur Eclipse : Open Project from... 
- Creation de PROJECT_NAME.entities et PROJECT_NAME.dao packages dans src/main/java

- dans PROJECT_NAME.dao : on doit avoir les interfaces DaoGeneric, DaoTABLE_NAME, DaoTABLE_NAMEImpl, la classe Context.java (singletons...)
- dans PROJECT_NAME.entities : on doit avoir les classes modeles et les attribues, don't forget les décotateurs @... constructeur vide pour Jpa, constructeurs au choix, getters, setters et hashcode/equals

Et voilà pour la base.
