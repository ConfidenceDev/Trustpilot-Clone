package me.confidencedev.companyservice.repository;

import me.confidencedev.companyservice.entity.Company;
import me.confidencedev.companyservice.model.CompanyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {}
