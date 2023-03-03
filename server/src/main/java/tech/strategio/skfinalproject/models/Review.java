package tech.strategio.skfinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private String movieTitle;

    private String movieOverview;

    private String moviePoster;

    private String review;

    @Id
    private String id;

    private String userId;

    private String username;

    public Review(String movieTitle, String movieOverview, String moviePoster, String review, String userId, String username) {
        this.movieTitle = movieTitle;
        this.movieOverview = movieOverview;
        this.moviePoster = moviePoster;
        this.review = review;
        this.userId = userId;
        this.username = username;
    }

}
