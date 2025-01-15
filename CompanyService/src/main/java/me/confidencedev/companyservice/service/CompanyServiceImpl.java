package me.confidencedev.companyservice.service;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.companyservice.entity.Company;
import me.confidencedev.companyservice.model.CompanyRequest;
import me.confidencedev.companyservice.model.Rating;
import me.confidencedev.companyservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String registerCompany(CompanyRequest companyRequest) {
        log.info("Registering company");
        Company company = Company.builder()
                .companyName(companyRequest.getCompanyName())
                .companyDescription(companyRequest.getCompanyDescription())
                .companyOwner(companyRequest.getCompanyOwner())
                .websiteUrl(companyRequest.getWebsiteUrl())
                .totalRating(Rating.ZERO)
                .created(Instant.now())
                .build();

        company = companyRepository.save(company);
        log.info("Company registered");
        return String.valueOf(company.getId());
    }
}
