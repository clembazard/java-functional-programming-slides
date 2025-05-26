return acteReferentialList.stream()
    .map(ActeUtils.isRelatedTo(acte))
    .map(ActeReferential::getDetails)
    .findFirst();