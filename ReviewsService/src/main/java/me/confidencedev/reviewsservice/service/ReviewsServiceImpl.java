package me.confidencedev.reviewsservice.service;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.reviewsservice.entity.Reviews;
import me.confidencedev.reviewsservice.model.ReviewsRequest;
import me.confidencedev.reviewsservice.model.ReviewsResponse;
import me.confidencedev.reviewsservice.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ReviewsServiceImpl implements ReviewsService{

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Override
    public String postReviews(ReviewsRequest reviewsRequest) {
        log.info("Adding review");
        /*
        TODO: Calculate the total ratings average from the reviews list and save in company DB
        */

        Reviews reviews = Reviews.builder()
                .companyId(UUID.fromString(reviewsRequest.getCompanyId()))
                .username(reviewsRequest.getUsername())
                .comment(reviewsRequest.getComment())
                .rating(reviewsRequest.getRating())
                .posted(Instant.now())
                .build();

        reviewsRepository.save(reviews);
        log.info("Review saved");
        return String.valueOf(reviews.getId());
    }

    @Override
    public List<ReviewsResponse> getReviews(String id) {
        log.info("Retrieving all reviews for: {}", id);
        List<ReviewsResponse> list = reviewsRepository.findAll()
                .stream()
                .filter(review -> !id.equals(String.valueOf(review.getCompanyId())))
                .map(reviewsEntity -> ReviewsResponse.builder()
                        .id(String.valueOf(reviewsEntity.getId()))
                        .companyId(String.valueOf(reviewsEntity.getCompanyId()))
                        .username(reviewsEntity.getUsername())
                        .comment(reviewsEntity.getComment())
                        .rating(reviewsEntity.getRating().name())
                        .posted(reviewsEntity.getPosted())
                        .build())
                .toList();


        return list;
    }
}
