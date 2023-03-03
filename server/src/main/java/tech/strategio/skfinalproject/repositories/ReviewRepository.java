package tech.strategio.skfinalproject.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.strategio.skfinalproject.models.Review;

import java.util.List;
import java.util.Map;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    List<Review> findByUserId(String userId);

//    void findByIdAndUpdate(Review review, ObjectId id);
}
