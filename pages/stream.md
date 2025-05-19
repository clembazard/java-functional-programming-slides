---
layout: section
transition: slide-up
---

# Stream

Handle values like a champion

<hr>

Java 8+

<!-- footer -->

[The Stream API Tutorial - Baeldung](https://www.baeldung.com/java-8-streams)

---

# Stream

## Qu'est-ce que c'est ?

- API
- Manipule des valeurs
- <span v-mark>Piping</span> fonctionnel de valeurs multiples
- Sans impact sur la source
- Aggregation d'éléments
- À usage unique ⚠️

---

# Stream

## Creation 

- À partir de valeurs

```java {all}{lines:true}
Stream<String> streamOfValues = Stream.of("a", "b", "c");
```

- À partir d'une liste

```java {all}{lines:true}
Collection<String> collection = List.of("a", "b", "c");
Stream<String> streamOfCollection = collection.stream();
```

- À partir d'un tableau

```java {all}{lines:true}
String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayFull = Arrays.stream(arr);
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // {"b", "c"}
```

---

# Stream

## Fabrication  

- Construction du Stream au fil de l'eau.
- ℹ️ Typage diamand nécessaire

```java {all|1}{lines:true}
Stream<String> streamBuilder = Stream.<String>builder()
    .add("a")
    .add("b")
    .add("c")
    .build();
```

---

# Stream

## Génération  

- La méthode `generate()` prend un `Supplier<T>` pour la génération d'élément
- Retourne un stream infini (jusqu'à saturation de la mémoire)
- La méthode `limit(int)` permet de spécifier la taille souhaitée

```java {all}{lines:true}
Stream<String> streamGenerated = Stream.generate(() -> "element")
    .limit(3);
// ["element", "element", "element"]
```

---

# Stream

## Génération itérative

- La méthode `iterate()` prend :g
    - Une valeur de départ 
    - Un `UnaryOperator<T>` pour la génération des itérations
- Retourne un stream infini (jusqu'à saturation de la mémoire)
- La méthode `limit(int)` permet de spécifier la taille souhaitée

```java {all}{lines:true}
Stream<Integer> streamIterated = Stream.iterate(0, n -> n + 2)
    .limit(5);
// [0, 2, 4, 6, 8]
```

<!-- 
La valeur de départ peut être de n'importe quel type
-->

