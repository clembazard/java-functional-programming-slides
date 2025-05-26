final int distinctLines = acteList.stream() 
    .map(Acte::getLigne) 
    .collect(Collectors.toSet()) 
    .size();  