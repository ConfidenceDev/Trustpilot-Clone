package me.confidencedev.reviewsservice.service;

import me.confidencedev.reviewsservice.model.ReviewsRequest;
import me.confidencedev.reviewsservice.model.ReviewsResponse;

import java.util.List;

public interface ReviewsService {
    String postReviews(ReviewsRequest reviewsRequest);

    List<ReviewsResponse> getReviews(String id);
}
