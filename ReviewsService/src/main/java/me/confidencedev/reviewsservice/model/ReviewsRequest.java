package me.confidencedev.reviewsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsRequest {
    private String companyId;
    private String username;
    private String comment;
    private Rating rating;
}
