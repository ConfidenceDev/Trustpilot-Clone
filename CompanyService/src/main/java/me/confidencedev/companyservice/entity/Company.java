package me.confidencedev.companyservice.entity;

import jakarta.persistence.*;
import lombok.*;
import me.confidencedev.companyservice.model.Rating;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "COMPANY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "COMPANY_NAME")
    @NonNull
    private String companyName;

    @Column(name = "COMPANY_DESCRIPTION")
    private String companyDescription;

    @Column(name = "COMPANY_OWNER")
    private String companyOwner;

    @Column(name = "WEBSITE_URL")
    @NonNull
    private String websiteUrl;

    @Column(name = "RATING")
    private Rating totalRating;

    @Column(name = "CREATED")
    private Instant created;
}
