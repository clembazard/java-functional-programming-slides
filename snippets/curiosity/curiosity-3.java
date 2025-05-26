public LocalDate calculateExpirationDate(final Dossier dossier) { 
  final List<ConfigurationExpiration> configurationList = findConfigurationService.findConfigurationExpiration(); 
  final ConfigurationExpiration configurationExpiration = configurationList.stream() 
    .filter(configurationMatcher.accept(dossier)) 
    .findFirst() 
    .orElse(null); 
  return configurationExpiration != null 
    ? calculateDate(configurationExpiration) 
    : null; 
} 