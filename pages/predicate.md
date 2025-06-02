---
layout: section
transition: slide-up
---

# Predicate

2b || !2b

<hr>

Java 8+

<!-- footer -->
[Predicate chain - Baeldung](https://www.baeldung.com/java-predicate-chain)

---

# Predicate

## Qu'est-ce ? 

- Interface fonctionnelle 
- Représente une question / un test
- Permet d'appliquer conditionnellement un traitement fonctionnel via Optional & Stream

---

# Predicate

## Exemple 

```java {all|5|all}{lines:true}
@Test
public void whenFilterList_thenSuccess(){
   List<String> names = List.of("Adam", "Alexander", "John", "Tom");
   List<String> result = names.stream()
     .filter(name -> name.startsWith("A"))
     .collect(Collectors.toList());
   
   assertEquals(2, result.size());
   assertThat(result, contains("Adam","Alexander"));
}
```

---
transition: fade
---

# Predicate

## Critères multiples    

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom");
```

<hr/>

````md magic-move

```java {all|4-5}{lines:true}
@Test
public void whenFilterListWithMultipleFilters_thenSuccess(){
    List<String> result = names.stream()
      .filter(name -> name.startsWith("A"))
      .filter(name -> name.length() < 5)
      .collect(Collectors.toList());

    assertEquals(1, result.size());
    assertThat(result, contains("Adam"));
}
```


```java {all|4}{lines:true}
@Test
public void whenFilterListWithComplexPredicate_thenSuccess(){
    List<String> result = names.stream()
      .filter(name -> name.startsWith("A") && name.length() < 5)
      .collect(Collectors.toList());

    assertEquals(1, result.size());
    assertThat(result, contains("Adam"));
}
```


```java {all|3-4,7}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingAnd_thenSuccess(){
    Predicate<String> predicate1 =  str -> str.startsWith("A");
    Predicate<String> predicate2 =  str -> str.length() < 5;
  
    List<String> result = names.stream()
      .filter(predicate1.and(predicate2))
      .collect(Collectors.toList());
        
    assertEquals(1, result.size());
    assertThat(result, contains("Adam"));
}
```


````

---
transition: fade
---

# Predicate

## Combinaison - and

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom");
```

<hr/>


```java {7}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingAnd_thenSuccess(){
    Predicate<String> predicate1 =  str -> str.startsWith("A");
    Predicate<String> predicate2 =  str -> str.length() < 5;
  
    List<String> result = names.stream()
      .filter(predicate1.and(predicate2))
      .collect(Collectors.toList());
        
    assertEquals(1, result.size());
    assertThat(result, contains("Adam"));
}
```

---
transition: fade
---


# Predicate

## Combinaison - or

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom");
```

<hr/>


```java {7}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingOr_thenSuccess(){
    Predicate<String> predicate1 =  str -> str.startsWith("J");
    Predicate<String> predicate2 =  str -> str.length() < 4;
    
    List<String> result = names.stream()
      .filter(predicate1.or(predicate2))
      .collect(Collectors.toList());
    
    assertEquals(2, result.size());
    assertThat(result, contains("John","Tom"));
}
```

---
transition: fade
---


# Predicate

## Négation - negate

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom");
```

<hr/>


```java {7}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingOrAndNegate_thenSuccess(){
    Predicate<String> predicate1 =  str -> str.startsWith("J");
    Predicate<String> predicate2 =  str -> str.length() < 4;
    
    List<String> result = names.stream()
      .filter(predicate1.or(predicate2.negate()))
      .collect(Collectors.toList());
    
    assertEquals(3, result.size());
    assertThat(result, contains("Adam","Alexander","John"));
}
```

---
transition: fade
---


# Predicate

## Négation - not

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom");
```

<hr/>


```java {7}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingOrAndPredicateNot_thenSuccess(){
    Predicate<String> predicate1 =  str -> str.startsWith("J");
    Predicate<String> predicate2 =  str -> str.length() < 4;
    
    List<String> result = names.stream()
      .filter(predicate1.or(Predicate.not(predicate2)))
      .collect(Collectors.toList());
    
    assertEquals(3, result.size());
    assertThat(result, contains("Adam","Alexander","John"));
}
```

---
transition: fade
---


# Predicate

## Négation - not

```java{all}{lines:true}
List<String> names = List.of("Adam", "Alexander", "John", "Tom", " ");
```

<hr/>


```java {4}{lines:true}
@Test
public void whenFilterListWithCombinedPredicatesUsingPredicateNot_thenSuccess(){
    List<String> result = names.stream()
      .filter(Predicate.not(String::isBlank))
      .collect(Collectors.toList());
    
    assertEquals(3, result.size());
    assertThat(result, contains("Adam","Alexander","John","Tom"));
}
```
