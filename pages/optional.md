---
layout: section
transition: slide-up
---

# Optional

***null*** ne devrait pas être une valeur.

<hr>

Java 8+

<!-- footer -->
[Optional - Baeldung](https://www.baeldung.com/java-optional)

[Optional uses - Baeldung](https://www.baeldung.com/java-optional-uses)

[NULL: The billion dollar mistake - HackerNoon](https://hackernoon.com/null-the-billion-dollar-mistake-8t5z32d6)

--- 

# Optional

## Qu'est-ce ? 

- Classe 
- Wrapper générique
- Représente la présence / absence de valeur
- Fondation essentielle pour le <span v-mark>piping</span> fonctionnel

--- 

# Optional

## Méthodes 

- Création
    - `of(T value)` Retourne une instance contenant la valeur 
    - `ofNullable(T value)` Retourne une instance contenant la valeur potentiellement nulle
    - `empty()` Retourne une instance vide
- Condition
    - `filter(Predicate<T> predicate)` Filtre conditionellement la valeur
- Transformation
    - `map(Function<T, U> predicate)` Transforme la valeur
- Extraction
    - `get()` Extrait la valeur ou lance `NoSuchElementException` si vide
    - `orElse(T other)` Extrait la valeur ou *other* si vide
    - `orElseThrow(Throwable throwable)` Extrait la valeur ou lance *throwable* si vide

---

# Optional 

## Impératif vs Fonctionnel

```java
// Syntaxe impérative
User user = userRepositoryWithNull.findById("2");
String upperCasedName = "";

if (user != null) {
    if (user.getName().startsWith("M")) {
        upperCasedName = user.getName().toUpperCase();
    }
}
```

<hr/>

```java
// Syntaxe déclarative (fonctionnelle)
String upperCasedName = userRepositoryWithOptional.findById("2") // retourne un Optional<User>
    .filter(u -> u.getName().startsWith("M")) // filtrage conditionnel
    .map(u -> u.getName().toUpperCase()) // transfor me si présent
    .orElse(""); // valeur par défaut si vide
```

---

# Optional 

```java
// Avec lambda
String upperCasedName = userRepositoryWithOptional.findById("2")
    .filter(u -> u.getName().startsWith("M"))
    .map(u -> u.getName().toUpperCase())
    .orElse("");
```

<hr/>

```java
Predicate<User> hasNameStartingWithM = u -> u.getName().startsWith("M");
Function<User, String> extractNameToUpperCase = u -> u.getName().toUpperCase();

// Avec références
String upperCasedName = userRepositoryWithOptional.findById("2")
    .filter(hasNameStartingWithM)
    .map(extractNameToUpperCase)
    .orElse("");
```

<v-clicks>

- Syntaxes sémantiquement identiques
- Référence de méthode dans les deux cas
- Méthode anynome pour le cas d'une lambda

</v-clicks>
