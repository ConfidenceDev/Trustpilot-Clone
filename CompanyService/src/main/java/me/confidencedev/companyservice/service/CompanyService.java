package me.confidencedev.companyservice.service;

import me.confidencedev.companyservice.model.CompanyRequest;
import me.confidencedev.companyservice.external.model.CompanyResponse;

public interface CompanyService {
    String registerCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyReviews(String companyId);
}
