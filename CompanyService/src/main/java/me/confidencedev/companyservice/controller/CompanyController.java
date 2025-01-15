package me.confidencedev.companyservice.controller;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.companyservice.model.CompanyRequest;
import me.confidencedev.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Log4j2
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@RequestBody CompanyRequest companyRequest){
        String companyId = companyService.registerCompany(companyRequest);
        log.info("Company Id: {}", companyId);
        return new ResponseEntity<>(companyId, HttpStatus.OK);
    }


}
