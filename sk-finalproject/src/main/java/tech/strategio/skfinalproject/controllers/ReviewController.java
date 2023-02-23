package tech.strategio.skfinalproject.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @PostMapping("/create")
    public void postNewReview (@RequestBody Map body) {
        String name = body.get("name").toString();
        String review = body.get("review").toString();
        System.out.println("New Review Posted: " + "\n" + name + "\n" +  review);
    }
}
