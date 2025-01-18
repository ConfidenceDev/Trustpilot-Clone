package me.confidencedev.companyservice.external.client;

import me.confidencedev.companyservice.exception.CustomException;
import me.confidencedev.companyservice.external.model.CompanyResponse.ReviewsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEWS-SERVICE/v1/reviews")
public interface ReviewsService {

    @GetMapping("/{companyId}")
    ResponseEntity<List<ReviewsResponse>> getReviews(@PathVariable String companyId);

    default ResponseEntity<Void> fallback(Exception e){
        throw new CustomException("Reviews service is not available", "UNAVAILABLE", 500);
    }
}
