---
layout: section
transition: slide-up
---

# Programmation fonctionnelle

De quoi ?!

<hr/>

[Functional programming paradigm - GeeksForGeeks](https://www.geeksforgeeks.org/functional-programming-paradigm/)
<br/>
[Programmation fonctionnelle - Wikipedia](https://fr.wikipedia.org/wiki/Programmation_fonctionnelle)
<br/>
[Lambda-calcul - Wikipedia](https://fr.wikipedia.org/wiki/Lambda-calcul)
<br/>
[Currying - Wikipedia](https://en.wikipedia.org/wiki/Currying)


---
layout: image-right
image: assets/church.jpg
---
# Programmation fonctionnelle

## Introduction

- Paradigme de programmation
- Syntaxe déclarative
- Fonctions (mathématiques) pures
    - Repose sur le *λ-calcul*
- Se concentre sur <span v-mark>*quoi*</span> résoudre, plutôt que <span v-mark>*comment*</span> résoudre
- Cadre théorique pour décrire des fonctions et leur évalutation
    - Développé par **Alonzo Church** (1930)
    - Capacité de calcul comparable à la machine de **Turing**

<style>
    img {
        max-height: 75vh;
    }
</style>



---
layout: statement
---

## Fun fact

![Alan Turing](/assets/turing.jpg)

**Alan Turing** (étudiant d'**Alonzo Chuch**) a créé la machine de **Turing**, laquelle a mené aux fondations de la programmation <span v-mark="0">impérative</span>.

<style>
img {
    max-height: 20vh;
    display: block;
    margin: auto;
    /* frame*/
    background: #fff;
    padding: 15px;
    border-style: solid;
    border-width: 15px;
    border-top-color: lighten(#000, 20%);
    border-right-color: lighten(#000, 0%);
    border-bottom-color: lighten(#000, 20%);
    border-left-color: lighten(#000, 0%);
    box-shadow: 2px 2px 4px rgba(0,0,0,.6);
}
</style>

---

# Programmation fonctionnelle

## λ-calcul 

- Développé par **Alonzo Church** (1930)
- Tout est fonction
- Fondation permettant de manipuler des *λ-expressions*
    - $\lambda x \cdot x + 2$ 
    - ${\displaystyle f} : x \mapsto x + 2$ (notation mathématique)
- ⚠️ Un seul argument par fonction

<!-- 
Haskell Curry - Logicien & Mathématicien américain
-->
---

# Programmation fonctionnelle

## Currying

- Introduit par **Haskell Curry**
- Logique combinatoire
- Fonction retourne une autre fonction
    - $\lambda x \cdot \lambda y \cdot x + y$
    - ${\displaystyle f} x \mapsto {\displaystyle f} y \mapsto x + y$ (notation mathématique)


---

# Programmation fonctionnelle

## Concepts clé

1. Fonctions pures
    - Comportement dépandant uniquement de ses arguments $\to$ prédictible
2. Fonctions sont des variables de classe
    - Peuvent consommer / retourner d'autres fonctions (ordre supérieur)
3. Variables immuables
    - Etat constant, limite les potentiels effets de bord
4. Transparence référentielle
    - Pas d'instruction d'affectation 
5. Récursion
    - Pas de boucle `for` ou `while` $\to$ itérations par récursion

<!--
- Transparence référentielle
    - Stocker une valeur ? Créer une nouvelle variable
    - Elimine les chances d'avoir des effets de bord
        - Une variable peut être remplacé par sa valeur n'importe où dans l'exécution
 -->

---

# Programmation fonctionnelle

## Avantages

- Compréhension / testing facile
- Pas d'effet de bord
    - Adapté au traitements parrallèles / concurrents
- Permet de traiter des fonctions comme des valeurs 
    - ex: passé en paramètre d'une fonction
- Evalutation paresseuse "lazy"
    - Evalué uniquement quand nécessaire
    - Limite les traitements innutiles et répétés

--- 

# Programmation fonctionnelle

## Inconvénients

- Lisibilité du code dégradé sur les fonctions les plus complexes
- Recours à la récursivité intimidant
- Composition de fonctions parfois délicate
- Récursion et les valeurs immuables peuvent dégrader les performances (dans certains cas)

--- 

# Programmation fonctionnelle

## Application

<br/> 

1. Calculs mathématiques
2. Traitements concurrents / parallèles
3. Programmation réactive
 
<br/>

## Langages compatibles

**Haskell**, **Erlan**, **OCaml**, **Python**, **Scala**, **JavaScript**, **Java**, etc.

<!-- 

Programmation réactive:
 - ReactiveX (RxJS, RxJava)
 - Reactor (Spring Webflux)


Facts : 
Whatsapp: Erlang pour ses besoin traitements conccurents
Facebook: Haskell dans son système anti-spam
-->