package me.confidencedev.reviewsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsResponse {

    private String id;
    private String companyId;
    private String username;
    private String comment;
    private String rating;
    private Instant posted;
}
