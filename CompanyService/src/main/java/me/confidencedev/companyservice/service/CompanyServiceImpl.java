package me.confidencedev.companyservice.service;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.companyservice.entity.Company;
import me.confidencedev.companyservice.exception.CustomException;
import me.confidencedev.companyservice.external.client.ReviewsService;
import me.confidencedev.companyservice.model.CompanyRequest;
import me.confidencedev.companyservice.external.model.CompanyResponse;
import me.confidencedev.companyservice.model.Rating;
import me.confidencedev.companyservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ReviewsService reviewsService;

    @KafkaListener(topics = "reviews", groupId = "reviewers")
    public void pullReview(String review){
        log.info(review);
    }

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

    @Override
    public CompanyResponse getCompanyReviews(String companyId) {
        log.info("Get details of company with id: {}", companyId);
        Company company = companyRepository.findById(UUID.fromString(companyId))
                .orElseThrow(() -> new CustomException("Company not found with id: " + companyId,
                        "NOT_FOUND",
                        404));
        List<CompanyResponse.ReviewsResponse> reviews;
        try{
            log.info("Fetching reviews from reviews service");
            reviews = reviewsService.getReviews(companyId).getBody();

            log.info("=================== Data retrieved");
            log.info(reviewsService.getReviews(companyId));
            log.info(reviews);
        }catch (Exception e){
            log.error("Error occurred while fetching reviews");
            reviews = List.of();
        }

        return CompanyResponse.builder()
                .id(String.valueOf(company.getId()))
                .companyName(company.getCompanyName())
                .companyOwner(company.getCompanyOwner())
                .websiteUrl(company.getWebsiteUrl())
                .totalRating(company.getTotalRating())
                .created(company.getCreated())
                .reviews(reviews)
                .build();
    }

}
