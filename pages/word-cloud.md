# Constat

<div class="cloud-container">
    <ul class="cloud" role="navigation" aria-label="Webdev word cloud">
    <li><span href="#" data-weight="2">Optional</span></li>
    <li><span href="#" data-weight="4">Je connaissais pas cette syntax</span></li>
    <li><span href="#" data-weight="2">Stream</span></li>
    <li><span href="#" data-weight="3">Fonctionnel ? </span></li>
    <li><span href="#" data-weight="5">Intéressant</span></li>
    <li><span href="#" data-weight="6">Je savais pas qu'on pouvait faire ça ! 🤯</span></li>
    <li><span href="#" data-weight="2">Consumer</span></li>
    <li><span href="#" data-weight="2">Predicate</span></li>
    <li><span href="#" data-weight="3">Comment on débug ?</span></li>
    <li><span href="#" data-weight="2">Provider</span></li>
    <li><span href="#" data-weight="5">C'est optimisé ?</span></li>
    <li><span href="#" data-weight="4">Le lead veux pas...</span></li>
    <li><span href="#" data-weight="2">Function</span></li>
    <li><span href="#" data-weight="5">Depuis quand on peut faire ça ?</span></li>
    <li><span href="#" data-weight="4">Mais pourquoi ?!</span></li>
    <li><span href="#" data-weight="2">Lambda</span></li>
    <li><span href="#" data-weight="3">Hmmm c'est pas pire 👍</span></li>
    </ul>
</div>

<style>
    .cloud-container {
    height: inherit;
    display: flex;
    align-items: center;
    justify-content: center;
    }

    ul.cloud {
    list-style: none;
    padding-left: 0;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: center;
    line-height: 2.75rem;
    }

    ul.cloud span {
    /*   
    Not supported by any browser at the moment :(
    --size: attr(data-weight number); 
    */
    --size: 4;
    --color: #a33;
    color: var(--color);
    font-size: calc(var(--size) * 0.25rem + 0.5rem);
    display: block;
    padding: 0.125rem 0.25rem;
    position: relative;
    text-decoration: none;
    /* 
    For different tones of a single color
    opacity: calc((15 - (9 - var(--size))) / 15); 
    */
    }

    ul.cloud span[data-weight="1"] { --size: 1; }
    ul.cloud span[data-weight="2"] { --size: 2; }
    ul.cloud span[data-weight="3"] { --size: 3; }
    ul.cloud span[data-weight="4"] { --size: 4; }
    ul.cloud span[data-weight="5"] { --size: 6; }
    ul.cloud span[data-weight="6"] { --size: 8; }
    ul.cloud span[data-weight="7"] { --size: 10; }
    ul.cloud span[data-weight="8"] { --size: 13; }
    ul.cloud span[data-weight="9"] { --size: 16; }

    ul[data-show-value] span::after {
    content: " (" attr(data-weight) ")";
    font-size: 1rem;
    }

    ul.cloud li:nth-child(2n+1) span { --color: #181; }
    ul.cloud li:nth-child(3n+1) span { --color: #33a; }
    ul.cloud li:nth-child(4n+1) span { --color: #c38; }

    ul.cloud span:focus {
    outline: 1px dashed;
    }

    ul.cloud span::before {
    content: "";
    position: absolute;
    top: 0;
    left: 50%;
    width: 0;
    height: 100%;
    background: var(--color);
    transform: translate(-50%, 0);
    opacity: 0.15;
    transition: width 0.25s;
    }

    ul.cloud span:focus::before,
    ul.cloud span:hover::before {
    width: 100%;
    }
</style>
