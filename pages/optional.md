---
layout: section
transition: slide-down
---

# Optional

***null*** ne devrait pas être une valeur.

<hr>

Java 8+

<!-- footer -->
[Baeldung - Optional](https://www.baeldung.com/java-optional)

--- 

# Optional

<v-clicks>

- Classe 
- Représente la présence / absence de quelque chose
- Wrapper générique
- Méthodes :
    - `of(T value)` Retourne une instance contenant la valeur 
    - `ofNullable(T value)` Retourne une instance contenant la valeur ou vide
    - `empty()` Retourne une instance vide
    - `orElse(T other)`  Retourne la valeur contenu dans l'***Optional*** ou *other*
- Méthodes Transitions : 
    - `filter(Predicate<T> predicate)` Filtre le contenu
    - `map(Function<T, U> predicate)` ____Transforme____ le contenu
</v-clicks>

---

# Optional 

## Syntaxe impérative vs déclarative

TODO

---

# Optional 

TODO