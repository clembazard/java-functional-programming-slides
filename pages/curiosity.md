---
layout: statement
transition: slide-up
---

# Curiosités

Qu'est-ce qui cloche par ici ? 🕵️


---
layout: statement
transition: fade
---

# 1

---
layout: center
transition: fade
---

````md magic-move

<<< @/snippets/curiosity/curiosity-1.java {all|2|3|4|2-3}{lines:true}

```java {all|1}{lines:true}
private BigDecimal getMontantActe(final Optional<ActeReferential> acte) { 
    if (acte.isPresent()) {
        ActeReferential act = acte.get();
        return act.getActeTarif() != null  
        ? act.getActeTarif().getBaseRoAmount()  
        : BigDecimal.ZERO; 
    }
} 
```

```java {all}{lines:true}
private BigDecimal getMontantActe(final ActeReferential acte) { 
    Optional<ActeReferential> actOptional = Optional.ofNullable(acte);
    return actOptional.isPresent() && actOptional.get().getActeTarif() != null  
    ? actOptional.get().getActeTarif().getBaseRoAmount()  
    : BigDecimal.ZERO; 
} 
```

```java {all}{lines:true}
private BigDecimal getMontantActe(final ActeReferential acte) { 
    Optional<BigDecimal> baseRoAmount = Optional.ofNullable(acte)
        .map(ActeReferential::getActeTarif)
        .map(ActeTarif::getBaseRoAmount);
    return baseRoAmount.orElse(BigDecimal.ZERO); 
} 
```

```java {all}{lines:true}
private BigDecimal getMontantActe(final ActeReferential acte) { 
    return Optional.ofNullable(acte)
        .map(ActeReferential::getActeTarif)
        .map(ActeTarif::getBaseRoAmount)
        .orElse(BigDecimal.ZERO); 
} 
```


````

<a href="https://hackernoon.com/null-the-billion-dollar-mistake-8t5z32d6" v-click="['6', '+2']">NULL: The billion dollar mistake - HackerNoon</a>

---
layout: center
---

Avant
<<< @/snippets/curiosity/curiosity-1.java {all}{lines:true}

<br/>
<hr/>

Après
```java {all}{lines:true}
private BigDecimal getMontantActe(final ActeReferential acte) { 
    return Optional.ofNullable(acte)
        .map(ActeReferential::getActeTarif)
        .map(ActeTarif::getBaseRoAmount)
        .orElse(BigDecimal.ZERO); 
} 
```

---
layout: statement
transition: fade
---

# 2

---
layout: center
transition: fade
---

````md magic-move

<<< @/snippets/curiosity/curiosity-2.java {all|2|3|4}{lines:true}

```java {all}{lines:true}
public ResponseEntity<DossierDto> getDossierDetails(final String numeroEngagement) { 
    final Optional<Dossier> optionalDossier = dossierService.findDossierByNumeroEngagement(numeroEngagement); 
    return optionalDossier.map(dossierMapper::toDossierDto)
        .map(ResponseEntity::ok) 
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT)); 
} 
```

```java {all}{lines:true}
public ResponseEntity<DossierDto> getDossierDetails(final String numeroEngagement) { 
    return dossierService.findDossierByNumeroEngagement(numeroEngagement)
        .map(dossierMapper::toDossierDto)
        .map(ResponseEntity::ok) 
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT)); 
} 
```

````

---
layout: center
---

Avant

<<< @/snippets/curiosity/curiosity-2.java {all}{lines:true}

<br/>
<hr/>

Après
```java {all}{lines:true}
public ResponseEntity<DossierDto> getDossierDetails(final String numeroEngagement) { 
    return dossierService.findDossierByNumeroEngagement(numeroEngagement)
        .map(dossierMapper::toDossierDto)
        .map(ResponseEntity::ok) 
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT)); 
} 
```

---
layout: statement
transition: fade
---

# 3 

---
layout: center
transition: fade
---

````md magic-move

<<< @/snippets/curiosity/curiosity-3.java {all|2|3|3-4|3-6|7-9}{lines:true}

```java {all|2-3,8}{lines:true}
public LocalDate calculateExpirationDate(final Dossier dossier) { 
  final List<ConfigurationExpiration> configurationList = findConfigurationService.findConfigurationExpiration(); 
  final LocalDate dateExpiration = configurationList.stream() 
    .filter(configurationMatcher.accept(dossier)) 
    .findFirst() 
    .map(this::calculateDate)
    .orElse(null); 
  return dateExpiration;
} 
```

```java {all}{lines:true}
public LocalDate calculateExpirationDate(final Dossier dossier) { 
  return findConfigurationService.findConfigurationExpiration(); 
    .stream() 
    .filter(configurationMatcher.accept(dossier)) 
    .findFirst() 
    .map(this::calculateDate)
    .orElse(null); 
} 
```


````

---
layout: center
---

Avant

<<< @/snippets/curiosity/curiosity-3.java {all}{lines:true}

<br/>
<hr/>

Après

```java {all}{lines:true}
public LocalDate calculateExpirationDate(final Dossier dossier) { 
  return findConfigurationService.findConfigurationExpiration(); 
    .stream() 
    .filter(configurationMatcher.accept(dossier)) 
    .findFirst() 
    .map(this::calculateDate)
    .orElse(null); 
} 
```

---
layout: statement
transition: fade
---

# 4

---
layout: center
transition: fade
---

````md magic-move

<<< @/snippets/curiosity/curiosity-4.java {all}{lines:true}

```java {all}{lines:true}
final int distinctLines = acteList.stream() 
    .map(Acte::getLigne) 
    .distinct()
    .count();  
```


````

---
layout: statement
transition: fade
--- 

# 5

---
layout: center
transition: fade
---

````md magic-move

<<< @/snippets/curiosity/curiosity-5.java {all}{lines:true}

```java {3-4}{lines:true}
return acteReferentialList.stream()
    .map(ActeUtils.isRelatedTo(acte))
    .map(ActeReferential::getDetails)
    .findFirst(); // Potentiel NullPointerException
```

```java {4}{lines:true}
return acteReferentialList.stream()
    .map(ActeUtils.isRelatedTo(acte))
    .map(ActeReferential::getDetails)
    .filter(Objects::nonNull)
    .findFirst();
```

````

<v-clicks>

- `findFirst()` retourne un *Optional* vide quand le stream est vide
- `findFirst()` lance `NullPointerException` quand l'élément présent est `null` 🧠

</v-clicks>
