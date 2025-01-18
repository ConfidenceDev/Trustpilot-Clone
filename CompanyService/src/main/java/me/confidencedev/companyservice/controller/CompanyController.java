package me.confidencedev.companyservice.controller;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.companyservice.model.CompanyRequest;
import me.confidencedev.companyservice.external.model.CompanyResponse;
import me.confidencedev.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/company")
@Log4j2
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping()
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@RequestBody CompanyRequest companyRequest){
        String companyId = companyService.registerCompany(companyRequest);
        log.info("Company Id: {}", companyId);
        return new ResponseEntity<>(companyId, HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompanyReviews(@PathVariable String companyId){
        CompanyResponse response = companyService.getCompanyReviews(companyId);
        log.info("Retrieved company reviews for id: {}", companyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
