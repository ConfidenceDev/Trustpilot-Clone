package me.confidencedev.reviewsservice.controller;

import lombok.extern.log4j.Log4j2;
import me.confidencedev.reviewsservice.model.ReviewsRequest;
import me.confidencedev.reviewsservice.model.ReviewsResponse;
import me.confidencedev.reviewsservice.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reviews")
@Log4j2
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping()
    public String hello(){
        return "Hello World!";
    }

    @PostMapping()
    public ResponseEntity<String> postReview(@RequestBody ReviewsRequest reviewsRequest){
        String uuid = reviewsService.postReviews(reviewsRequest);
        log.info("Review added");
        return new ResponseEntity<>(uuid, HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<ReviewsResponse>> getReviews(@PathVariable (name = "companyId") String id){
        List<ReviewsResponse> reviewsList = reviewsService.getReviews(id);
        log.info("Retrieving all reviews for company with id: {}", id);
        return new ResponseEntity<>(reviewsList, HttpStatus.OK);
    }
}
