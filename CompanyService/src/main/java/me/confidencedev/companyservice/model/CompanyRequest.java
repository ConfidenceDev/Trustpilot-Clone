package me.confidencedev.companyservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRequest {
    private String companyName;
    private String companyDescription;
    private String  companyOwner;
    private String websiteUrl;
}
