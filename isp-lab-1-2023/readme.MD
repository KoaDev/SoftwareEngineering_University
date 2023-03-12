# Exemplu proiect template pentru laboratoarele ISP

Dependentele proiectlui:
- Maven 3 
- Java 1.8 

Pentru a rula proiectul se va executa comanda mvn din radacina proiectului unde sa gaseste fisierul pom.xml.

La rulare se va apela metoda main ce face parte din clasa specificata in fisierul pom.xml in proprietate 'mainClass':

    <mainClass>Example</mainClass>

Pentru a transmite argumente din linia de comanda atunci cand se utilizeaza maven se va modifica elementul 'commandlineArgs' in fisierl pom.xml conform exemplului:

    <commandlineArgs>-jar ${project.build.directory}/${project.build.finalName}-${shadedClassifierName}.jar arg1 arg2</commandlineArgs>

## Rularea testelor

Pentru a rula toate testele JUnit se va rula comanda:

    mvn test

## Rularea programului 

    mvn compile exec:java 

## Rulare default

Pentru a executa un ciclu complet de compilare, testare si rulare sa executa comanda:

    mvn

Prin comanda 'mvn' maven va rula 'default maven goals' setate in fisierul pom.xml, si anume:

    <defaultGoal>clean compile package exec:java</defaultGoal> 

## Rulare alternativa utilizand mvn wrapper 

Alternativ, comenzile anterioare pot fi rulate utilizand mvn wrapper (https://github.com/takari/maven-wrapper) utilizand comanda mvnw in cazul in care maven nu este instalat. Exemplu:

    mvnw test 
    
## Generarea documentatiei javadoc

Pentru a genera documentatia proiectului se va executa comanda:

    mvn javadoc:javadoc
   


