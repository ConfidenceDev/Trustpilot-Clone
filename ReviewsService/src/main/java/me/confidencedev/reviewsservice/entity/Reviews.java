package me.confidencedev.reviewsservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.confidencedev.reviewsservice.model.Rating;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "REVIEWS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviews {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "COMPANY_ID")
    private UUID companyId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "RATING")
    private Rating rating;

    @Column(name = "POSTED")
    private Instant posted;
}
