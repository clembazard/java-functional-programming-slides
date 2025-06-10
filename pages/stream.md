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
[Stream cheat sheet - JRebel](https://www.jrebel.com/system/files/java-8-streams-cheat-sheet.pdf)

---

# Stream

## Qu'est-ce que c'est ?

- API
- <span v-mark>Pipeline</span> fonctionnel sur une ou plusieurs valeurs
- Ce n'est pas une structure de données
- Sans impact sur la source


---

# Stream

## Méthodes 

- Création
    - `of(T... values)` Retourne une instance contenant les valeurs 
    - `ofNullable(T value)` Retourne une instance contenant la valeur, potentiellement vide
    - `empty()` Retourne une instance vide
- Condition
    - `filter(Predicate<T> predicate)` Filtre conditionnellement la valeur
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

```java {all|1|2|3|all}{lines:true}
List<String> elements = Stream.of("a", "b", "c")
    .filter(element -> element.contains("b"))
    .collect(Collectors.toList());
```

<!-- Un bon pipeline c'est quoi ? -->

---

# Stream

## Source - Création 

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

```java {all}{lines:true}
Stream<String> streamBuilder = Stream.<String>builder()
    .add("a")
    .add("b")
    .add("c")
    .build();
```

<!-- Sans le typage diamant ça retourne un Stream<Object> -->

---

# Stream

## Source - Génération  

- `generate()` prend un `Supplier<T>` pour la génération d'élément
- Retourne un stream infini
- `limit(int)` permet de spécifier la taille souhaitée

```java {all}{lines:true}
Stream<String> streamGenerated = Stream.generate(() -> "element")
    .limit(3);
// ["element", "element", "element"]
```

---

# Stream

## Source - Génération itérative

- `iterate()` prend :
    - Une valeur initiale 
    - Un `UnaryOperator<T>` pour générer les itérations
- Retourne un stream infini
- `limit(int)` permet de spécifier la taille souhaitée

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

- Retournent toujours un Stream
- Chainable
- Lazy (paresseuses / sans effets)
    - Invoquées à l’exécution d'une opération terminale

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

<!-- 
Processing streams lazily allows for significant efficiencies; in a pipeline such as the filter-map-sum example above, filtering, mapping, and summing can be fused into a single pass on the data, with minimal intermediate state. Laziness also allows avoiding examining all the data when it is not necessary; for operations such as "find the first string longer than 1000 characters"
-->

---

# Stream

## Opérations intermédiaires - Ordre de chaînage


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

<span v-click>🧠 Plaçons les opérations qui réduisent le stream avant les opérations qui s'appliquent à chaque élément</span>

---

# Stream

## Opérations intermédiaires

- `limit(long maxSize)` Retourne un stream tronqué d'une taille maximale de `maxSize`
- `skip(long n)` Retourne un stream les elements restant après avoir passé les n premiers
- `distinct()` Retourne un stream sans doublon (utilise la méthode `equals()`)

<br/>

- `filter(Predicate<T> predicate)` Prend les éléments correspondants au prédicat
- `takeWhile(Predicate<T> predicate)` Prend les premiers éléments tant que le prédicat correspond
- `dropWhile(Predicate<T> predicate)` Ignore les premiers éléments tant que le prédicat correspond

---

# Stream

## Opérations intermédiaires

- `map(Function<T, U> mapper)` Transforme chaque élément
- `flatMap(Function<T, Stream<U>> mapper)` Transforme chaque élément, aplatit le Stream résultant
- `peek(Consumer<T> consumer)` Applique le ***consumer*** sur chaque élément puis retourne la source  <br/> 
    - ⚠️ Effet de bord possible

<br/>

- `sorted()` Trie par ordre croissant 
    - Applicable sur les objets implémentant `Comparable`
- `sorted(Comparator<T> comparator)` Trie selon le comparateur fourni

---

# Stream

## Opération terminale

- Peuvent traverser le ***Stream*** pour produire un résultat / un effet de bord
- ⚠️ Une seule par ***Stream*** maximum
    - Retourne un résultat qui n'est pas un ***Stream***
    - Après le ***Stream*** est considéré consommé 
- Invocation immédiate (eager)

````md magic-move
```java {all|4|5}{lines:true}
Stream<String> stream = Stream.of("a", "b", "c")
    .filter(element -> element.contains("b"));

Optional<String> anyElement = stream.findAny(); // OK
Optional<String> firstElement = stream.findFirst(); // throws IllegalStateException
```

```java {all|5-6}{lines:true}
List<String> elements = Stream.of("a", "b", "c")
    .filter(element -> element.contains("b"))
    .toList();

Optional<String> anyElement = elements.stream().findAny(); // OK
Optional<String> firstElement = elements.stream().findFirst(); // OK
```
````

<!-- Il faut répartir de la source pour effectuer n pipelines -->

---

# Stream

## Opération terminale - Bon à savoir

- Pas d'interférence avec la source
- Source modifiable jusqu'à invocation de l'opération terminale

```java {all}{lines:true}
List<String> list = new ArrayList(Arrays.asList("one", "two"));
Stream<String> stream = list.stream();

list.add("three");

String joined = stream.collect(Collectors.joining(" "));
// joined = "one two three"
```

---

# Stream

## Opération terminale

- `boolean allMatch(Predicate<T> predicate)` Retourne *true* si tous éléments correspondent
- `boolean anyMatch(Predicate<T> predicate)` Retourne *true* si au moins un élément correspond
- `boolean noneMatch(Predicate<T> predicate)` Retourne *true* si aucun élément ne correspond

<br/>

- `Optional<T> findFirst(Predicate<T> predicate)` Retourne le premier correspondant
- `Optional<T> findAny(Predicate<T> predicate)` Retourne n'importe lequel correspondant <br/> (***Stream*** parrallèle ou infini)

<br/>

- `Optional<T> min(Comparator<T> comparator);` Retourne le minimum selon le comparator
- `Optional<T> max(Comparator<T> comparator);` Retourne le maximum selon le comparator

---

# Stream

## Opération terminale

- `long count()` Compte les éléments du Stream
- `T[] toArray()` Collecte les éléments dans un tableau
- `List<T> toList()` Collecte les éléments dans une liste
    - ⚠️ Attention, liste immuable

<br/>

- `Optional<R> reduce(BinaryOperator<T> accumulator)` <br/> Réduit l'ensemble des éléments à un résultat unique selon l'*accumulator*
- `R collect(Collector<T, A, R> collector)` Collecte les éléments selon le collector fourni

<br/>

- `void forEach(Consumer<T> consumer)` Applique le *consumer* pour chaque élément de la liste <br/>(effet de bord)

---

# Stream

## Opération terminale - Collect

```java {all}{lines:true}
List<Product> productList = List.of(new Product(23, "potatoes"),
    new Product(14, "orange"), 
    new Product(13, "lemon"),
    new Product(23, "bread"), 
    new Product(13, "sugar"));
```

<hr/>

````md magic-move

<!-- to list -->
```java {all}{lines:true}
List<String> collectorCollection = productList.stream()
    .map(Product::getName)
    .collect(Collectors.toList()); // ⚠️ Liste immuable
```

<!-- toString -->
```java {all}{lines:true}
String listToString = productList.stream()
    .map(Product::getName)
    .collect(Collectors.joining(", "));
```

<!-- toAverage -->
```java {all}{lines:true}
double averagePrice = productList.stream()
    .collect(Collectors.averagingInt(Product::getPrice));
```

<!-- toSum -->
```java {all}{lines:true}
int summingPrice = productList.stream()
    .collect(Collectors.summingInt(Product::getPrice));
```

<!-- groupingBy -->
```java {all}{lines:true}
Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
  .collect(Collectors.groupingBy(Product::getPrice));
```

````

<!-- 
 Examples: 
 - toList
 - toString
 - toAverage
 - toSum
 - groupingBy
-->

---
transition: fade
---

# Stream

## Opération terminale - Reduce

- 3 variantes
    - `Optional<R> reduce(BinaryOperator<T> accumulator)` 
    - `R reduce(T identity, BinaryOperator<T> accumulator)` 
    - `R reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<T> combiner)`

---
transition: fade
---

# Stream

## Opération terminale - Reduce

`Optional<R> reduce(BinaryOperator<T> accumulator)`

- `accumulator` Fonction qui spécifie la logique d'aggrégation des éléments

<br/>
```java {all}{lines:true}
OptionalInt reduced = IntStream.range(1, 4)
    .reduce((a, b) -> a + b);

// reduced = 6 (1 + 2 + 3)
```

---
transition: fade
---

# Stream

## Opération terminale - Reduce

`R reduce(T identity, BinaryOperator<T> accumulator)`

- `identity` Valeur initiale pour l'accumulator / Valeur par défaut si le ***Stream*** est vide
- `accumulator` Fonction qui spécifie la logique d'aggrégation des éléments


```java {all|2|3|5}{lines:true}
int reducedTwoParams = IntStream.range(1, 4)
    .reduce(10, 
        (a, b) -> a + b);

// reducedTwoParams = 16 (10 + 1 + 2 + 3)
```


---
transition: fade
---

# Stream

## Opération terminale - Reduce

`R reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<T> combiner)`

- `identity` Valeur initiale pour l'accumulator / Valeur par défaut si le ***Stream*** est vide
- `accumulator` Fonction qui spécifie la logique d'aggrégation des éléments
- `combiner` Fonction qui aggrège les résultats de l'accumulator - parrallèle uniquement

````md magic-move

```java {all|2|3|4-7|9}{lines:true}
int reducedParams = Stream.of(1, 2, 3)
    .reduce(10, 
    (a, b) -> a + b, 
    (a, b) -> {
        log.info("combiner was called");
        return a + b;
    });

// reducedParams = 16 (10 + 1 + 2 + 3)
```

```java {2|5-8|10-12}{lines:true}
int reducedParams = Stream.of(1, 2, 3)
    .parallel()
    .reduce(10, 
    (a, b) -> a + b, 
    (a, b) -> {
        log.info("combiner was called");
        return a + b;
    });

/* reducedParams = 36 
 * Aggrétation parrallèle: (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;)
 * Combinaison : (11 + 12 = 23; 23 + 13 = 36) */
```

````

---
layout: image
image: /java-8-streams-cheat-sheet.png
backgroundSize: contain
---
