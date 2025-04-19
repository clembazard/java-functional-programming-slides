---
layout: section
transition: slide-up
---
 

# Bases

## Java

---

# Functional interface

Interface qui n'as qu'une méthode à implémenter
````md magic-move

<<< @/snippets/functional-interface/fi-single-method.java {all|4-5|1,4-5|all}{lines:true}

<<< @/snippets/functional-interface/fi-multiple-methods.java {all|4-5|all}{lines:true}

<<< @/snippets/functional-interface/fi-multiple-methods-decoratorless.java {all}{lines:true}

````
<!-- Footer -->

[Functional interfaces - Baeldung](https://www.baeldung.com/java-8-functional-interfaces)

---

# Function interface

Une interface pour les gouverner toutes 💍.

<<< @/snippets/functional-interface/Function.java {all|1-4}{lines:true}


---
layout: section
---

# Lambda expressions

Nouvelle syntaxe d'écriture d'une méthode


---

# Expression lambda

````md magic-move

<<< @/snippets/functional-interface/FunctionImpl.java {all}{lines:true}

```java
public class MyClass {

    // new style anonymous implementation - lambda expression
    private final Function<String, String> greeter = who -> {
        return "hello ".concat(who);
    }

}
```

<<< @/snippets/lambda-expression/FunctionImpl.java {all}{lines:true}

````
<v-clicks>

- Plus court
- Plus clair
- Plus concis

🔉 Réduction de bruit

</v-clicks>

---
layout: section
---

# Encore mieux ! 😎
Référence de méthode

---

 # Référence de méthode

````md magic-move

<<< @/snippets/lambda-expression/FunctionImpl.java {all}{lines:true}

<<< @/snippets/method-reference/FunctionImpl.java {all}{lines:true}

````

<v-clicks>

- Encore plus court
- Encore plus clair
- Encore plus concis
- Nommage de variable inutile ⛱️

🔉 <span v-mark.red="3">Réduction de bruit</span>

</v-clicks>