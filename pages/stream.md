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
- <span v-mark>Piping</span> fonctionnel de une ou plusieurs valeurs
- Sans impact sur la source


---

# Stream

## Méthodes 

- Création
    - `of(T... values)` Retourne une instance contenant les valeurs 
    - `ofNullable(T value)` Retourne une instance contenant la valeur, potentiellement vide
    - `empty()` Retourne une instance vide
- Condition
    - `filter(Predicate<T> predicate)` Filtre conditionellement la valeur
- Transformation
    - `map(Function<T, U> predicate)` Transforme la valeur
- Sélection
    - `limit(long maxSize)` Retourne un stream tronqué d'une taille maximale de `maxSize`
    - `skip(long n)` Retourne un stream les elements restant après avoir passé les n premiers
    - `distinct()` Retourne un stream sans doublon (utilise la méthode `equals()`)

---

# Stream

## Pipeline

1. Source
2. Opération(s) intermédiaire(s)
3. Opération terminale
    - ⚠️ Une seule par ***Stream***
    - Retourne un résultat qui n'est pas un ***Stream***

```java {all|1|2|3|all}{lines:true}
List<String> elements = Stream.of("a", "b", "c")
    .filter(element -> element.contains("b"))
    .collect(Collectors.toList());
```

<!-- Un bon pipeline c'est quoi ? -->

---

# Stream

## Source - Creation 

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

## Source - Fabrication  

- Construction du Stream au fil de l'eau.
- ⚠️ Typage nécessaire sur la méthode `<T>builder()` 

```java {all|1}{lines:true}
Stream<String> streamBuilder = Stream.<String>builder()
    .add("a")
    .add("b")
    .add("c")
    .build();
```

---

# Stream

## Source - Génération  

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

## Source - Génération itérative

- La méthode `iterate()` prend :
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

---

# Stream

## Opérations intermédiaires

- Retournent un nouveau Stream
- Chainables
- Paresseuses / sans effets
    - Invoquées à l'éxécution d'une opération terminale

````md magic-move
```java {all}{lines:true}
List<String> list = List.of("abc1", "abc2", "abc3");
Stream<String> stream = list.stream()
    .skip(1)
    .map(element -> element.substring(0, 3))
    .sorted();
```

```java {all}{lines:true}
List<String> list = List.of("abc1", "abc2", "abc3");
long size = list.stream()
    .skip(1)
    .map(element -> element.substring(0, 3))
    .sorted()
    .count();
```
````



---

# Stream

## Opérations intermédiaires - Ordre du chainage


```java {all}{lines:true}
List<String> list = List.of(“abc1”, “abc2”, “abc3”);
```

<hr/>

````md magic-move
```java {all}{lines:true}
long size = list.stream()
    .map(this::expensiveProcess) // invoked 3 times
    .skip(2)
    .count();
```

```java {all}{lines:true}
long size = list.stream()
    .skip(2)
    .map(this::expensiveProcess) // invoked only once
    .count();
```
````

<span v-click>🧠 Plaçons les opérations qui réduisent le stream avant les opération qui s'appliquent à chaque élément</span>

---

# Stream

## Opérations intermédiaires

- `filter(Predicate<T> predicate)` Prend les éléments correspondants au prédicat
- `takeWhile(Predicate<T> predicate)` Prend les premiers éléments tant que le prédicat correspont
- `dropWhile(Predicate<T> predicate)` Ignore les premiers éléments tant que le prédicat correspont

<hr/>

- `limit(long maxSize)` Limite
- `skip(long n)` Ignore
- `distinct()` Dédoublonne
- `sorted()` Trie par ordre croissant
- `sorted(Comparator<T> comparator)` Trie selon le comparateur si fourni

<hr/>

- `map(Function<T, U> mapper)` Transforme
- `flatMap(Function<T, Stream<U>> mapper)` Transforme et applatit le Stream résultant
