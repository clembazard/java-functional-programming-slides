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
image: /church.jpg
---
# Programmation fonctionnelle

## Introduction

- Paradigme de programmation
- Syntaxe déclarative
- Fonctions (mathématiques) pures
    - Repose sur le *λ-calcul*
- Se concentre sur <span v-mark>*quoi*</span> résoudre, plutôt que <span v-mark>*comment*</span> résoudre
- Cadre théorique pour décrire des fonctions et leur évaluation
    - Développé par **Alonzo Church** (1930)
    - Capacité de calcul comparable à la machine de **Turing**

<style>
    img {
        max-height: 75vh;
    }
</style>



---
layout: image-left
image: /turing.jpg
---

# Fun fact

## 

**Alan Turing**, créateur de la machine de **Turing**, <br/> laquelle a mené aux fondations de la programmation <span v-mark="0">impérative</span>, <br/> était étudiant d'**Alonzo Chuch**.

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
    - Comportement dépendant uniquement de ses arguments $\to$ prédictible
2. Fonctions sont des variables de classe
    - Peuvent consommer / retourner d'autres fonctions (ordre supérieur)
3. Variables immuables
    - État constant, limite les potentiels effets de bord
4. Transparence référentielle
    - Pas d'instruction d'affectation 
5. Récursion
    - Pas de boucle `for` ou `while` $\to$ itérations par récursion

<!--
- Transparence référentielle
    - Stocker une valeur ? Créer une nouvelle variable
    - Élimine les chances d'avoir des effets de bord
        - Une variable peut être remplacé par sa valeur n'importe où dans l'exécution
 -->

---

# Programmation fonctionnelle

## Avantages

- Compréhension / testing facile
- Pas d'effet de bord
    - Adapté aux traitements parallèles / concurrents
- Permet de traiter des fonctions comme des valeurs 
    - ex: passé en paramètre d'une fonction
- Evaluation paresseuse "lazy"
    - Évalué uniquement quand nécessaire
    - Limite les traitements inutiles et répétés

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
Whatsapp: Erlang pour ses besoin traitements concurrents
Facebook: Haskell dans son système anti-spam
-->