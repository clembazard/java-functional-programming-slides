public ResponseEntity<DossierDto> getDossierDetails(final String numeroEngagement) { 
    final Optional<Dossier> optionalDossier = dossierService.findDossierByNumeroEngagement(numeroEngagement); 
    return optionalDossier.map(dossier -> ResponseEntity.ok(dossierMapper.toDossierDto(dossier))) 
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT)); 
} 