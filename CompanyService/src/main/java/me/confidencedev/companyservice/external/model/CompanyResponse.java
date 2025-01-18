package me.confidencedev.companyservice.external.model;
import lombok.*;
import me.confidencedev.companyservice.model.Rating;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponse {

    private String id;
    private String companyName;
    private String companyDescription;
    private String companyOwner;
    private String websiteUrl;
    private Rating totalRating;
    private Instant created;
    private List<ReviewsResponse> reviews;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ReviewsResponse {

        private String id;
        private String companyId;
        private String username;
        private String comment;
        private Rating rating;
        private Instant posted;
    }

}
