---
# You can also start simply with 'default'
theme: seriph
# random image from a curated Unsplash collection by Anthony
# like them? see https://unsplash.com/collections/94734566/slidev
background: /DA25_TEAMS_4.png
# some information about your slides (markdown enabled)
title: ☕ Programmation Fonctionnelle en Java sans grimacer 😬
# apply unocss classes to the current slide
class: text-center
# https://sli.dev/features/drawing
drawings:
  persist: false
# slide transition: https://sli.dev/guide/animations.html#slide-transitions
transition: slide-left
# enable MDC Syntax: https://sli.dev/features/mdc
mdc: true
# open graph
# seoMeta:
#  ogImage: https://cover.sli.dev
# aspect ratio for the slides
aspectRatio: 16/9
addons:
  - slidev-component-pager
---

# ☕ Programmation Fonctionnelle en Java sans grimacer 😬

Pour développeurs débutants et expérimentés

---
layout: quote
---

# Inspiration

<<< @/snippets/curiosity/curiosity-1.java {all}{lines:true}

---
src: ./pages/word-cloud.md
---

---
src: ./pages/whoami.md
---

---
src: ./pages/introduction.md
---

---
src: ./pages/back-to-basics/functional-interface.md
---

---
src: ./pages/back-to-basics/function-compositing.md
---

---
src: ./pages/optional.md
---


---
src: ./pages/predicate.md
---

---
src: ./pages/stream.md
---

---
src: ./pages/curiosity.md
---

---
layout : center
---

# 😉 Prenez soin du code ! 

<div class="qr-container">
  <!-- Openfeedback -->
  <div class="qr-block">
    <img src="/openfeedback-qr.svg"/>
    <span>Open Feedback</span>
  </div>
  <!-- Slides repo -->
  <div class="qr-block">
    <img src="/slides-repo-qr.svg"/>
    <span>Slides</span>
  </div>
</div>

<style>
  .qr-container {
    display: flex;
    justify-content: space-evenly;

    img {
      width: 15em;
    }
  }

  .qr-block {
    display: flex;
    flex-direction: column;
 
    span {
      text-align: center;
    }
  }
</style>