package com.watchitnow.service;

import com.watchitnow.database.model.entity.ProductionCompany;

import java.util.Map;
import java.util.Set;

public interface ProductionCompanyService {
    Map<String, Set<ProductionCompany>> getProductionCompaniesFromResponse(Object responseById, Object type);

    void saveAllProductionCompanies(Set<ProductionCompany> productionCompanies);
}
