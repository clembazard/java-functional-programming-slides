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
- Pipeline de traitement pour chaque élement
- Sans impact sur la source
- Aggregation d'éléments
- À usage unique ⚠️


--- 

# Stream

## Creation - A partir d'un tableau / d'une liste

```java {all}{lines:true}
Collection<String> collection = List.of("a", "b", "c");
Stream<String> streamOfCollection = collection.stream();
```
<hr/>

```java {all}{lines:true}
String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayFull = Arrays.stream(arr);
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
```


