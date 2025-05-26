private BigDecimal getMontantActe(final Optional<ActeReferential> acte) { 
    return acte.isPresent() && acte.get().getActeTarif() != null  
    ? acte.get().getActeTarif().getBaseRoAmount()  
    : BigDecimal.ZERO; 
} 