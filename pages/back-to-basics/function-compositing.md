---
layout: section
transition: slide-up
---

# Function compositing

---

# Function compositing

Il est possible de composer une fonction à partir d'autres fonctions

<<< @/snippets/functional-interface/Function.java {all|6-9|6-14}{lines:true}

---

# Function compositing
Composition à priori ou à posteriori

````md magic-move
<<< @/snippets/compositing/FunctionCompositing.java {all|3-5|7-9|all}{lines:true}
<<< @/snippets/compositing/UnaryOperatorCompositing.java {all}{lines:true}
````

<v-click>

🔉 <span v-mark.red="5">Réduction de bruit</span>

</v-click>

---

# Interfaces fonctionnelle incluse 🧠

<table>
    <thead>
        <tr>
            <td>Interface</td>
            <td>Takes</td>
            <td>Return</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Consumer</td>
            <td>T</td>
            <td>void</td>
        </tr>
        <tr>
            <td>Provider</td>
            <td>void</td>
            <td>T</td>
        </tr>
        <tr>
            <td>Predicate</td>
            <td>T</td>
            <td>Boolean</td>
        </tr>
    </tbody>
</table>
