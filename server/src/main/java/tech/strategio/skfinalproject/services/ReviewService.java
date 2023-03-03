package tech.strategio.skfinalproject.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import tech.strategio.skfinalproject.models.Review;
import tech.strategio.skfinalproject.repositories.ReviewRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createReview(Review review) {
        reviewRepository.save(review);
        System.out.println("New Review: " + review);
    }

    public List<Review> getAllUserReviews(String userId){
        return reviewRepository.findByUserId(userId);
    }

    public List<Review> getAllReviewsAllUsers(){
        return reviewRepository.findAll();
    }

    public void deleteReview(ObjectId id) {
        reviewRepository.deleteById(id);
    }

    public Review getReviewById(ObjectId id) {
        return reviewRepository.findById(id).get();
    }

//    public void updateReview(ObjectId id, Review review) {
//        Review newReview = review;
//        reviewRepository.findByIdAndUpdate(newReview, id);
//    }
}