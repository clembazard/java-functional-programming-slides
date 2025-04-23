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

# Interfaces fonctionnelle incluse

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
            <td>IntFunction</td>
            <td>Integer</td>
            <td>Integer</td>
        </tr>
        <tr>
            <td>LongFunction</td>
            <td>Long</td>
            <td>Long</td>
        </tr>
        <tr>
            <td>DoubleFunction</td>
            <td>Double</td>
            <td>Double</td>
        </tr>
    </tbody>
</table>

---

# Interfaces fonctionnelle incluse

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
            <td>ToIntFunction</td>
            <td>T</td>
            <td>Integer</td>
        </tr>
        <tr>
            <td>ToLongFunction</td>
            <td>T</td>
            <td>Long</td>
        </tr>
        <tr>
            <td>ToDoubleFunction</td>
            <td>T</td>
            <td>Double</td>
        </tr>
    </tbody>
</table>

---

# Interfaces fonctionnelle incluse

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
            <td>DoubleToIntFunction</td>
            <td>Double</td>
            <td>Integer</td>
        </tr>
        <tr>
            <td>DoubleToLongFunction</td>
            <td>Double</td>
            <td>Long</td>
        </tr>
        <tr>
            <td>IntToDoubleFunction</td>
            <td>Integer</td>
            <td>Double</td>
        </tr>
    </tbody>
</table>

--- 

# Interfaces fonctionnelle incluse

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
            <td>T</td>
            <td>void</td>
        </tr>
        <tr>
            <td>Predicate</td>
            <td>T</td>
            <td>Boolean</td>
        </tr>
    </tbody>
</table>
