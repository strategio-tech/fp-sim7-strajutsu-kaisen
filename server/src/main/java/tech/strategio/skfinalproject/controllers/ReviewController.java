package tech.strategio.skfinalproject.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.strategio.skfinalproject.models.Review;
import tech.strategio.skfinalproject.models.User;
import tech.strategio.skfinalproject.services.ReviewService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public HttpStatus createNewReview (@RequestBody Map body) {
        Review review = new Review(body.get("movieTitle").toString(), body.get("movieOverview").toString(), body.get("moviePoster").toString(),
                body.get("review").toString(), body.get("userId").toString(), body.get("username").toString());
        reviewService.createReview(review);
        return HttpStatus.CREATED;
    }

    @GetMapping("/{id}")
    public List<Review> getReviewById(@RequestParam String userId) {
        List<Review> reviews = reviewService.getAllUserReviews(userId);
        return reviews;
    }

    @GetMapping("/all-users")
    public List<Review> getAllReviewsAllUsers() {
        List<Review> reviews = reviewService.getAllReviewsAllUsers();
        return reviews;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteReview(@RequestParam String reviewId) {
        reviewService.deleteReview(new ObjectId(reviewId));
        return HttpStatus.OK;
    }

//    @GetMapping("/edit/{id}")
//    public ResponseEntity<Review> getReviewById(@RequestParam String reviewId) {
//        Review review = reviewService.getReviewById(new ObjectId(reviewId));
//        return new ResponseEntity<>(review, HttpStatus.OK);
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Review> updateReview(@RequestParam String reviewId, @RequestBody Map body) {
//        Review review = new Review(body.get("movieTitle").toString(), body.get("movieOverview").toString(), body.get("moviePoster").toString(),
//                body.get("review").toString(), body.get("userId").toString(), body.get("username").toString());
//        reviewService.updateReview(new ObjectId(reviewId), review);
//        return new ResponseEntity<>(review, HttpStatus.OK);
//    }
}
