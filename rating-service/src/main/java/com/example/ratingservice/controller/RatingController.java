package com.example.ratingservice.controller;

import com.example.ratingservice.entity.Rating;
import com.example.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class RatingController {

    RatingService ratingService;
    private static final DecimalFormat df = new DecimalFormat("0.0");

    @PostMapping("/add")
    public void addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
    }

    @GetMapping("/getbyid")
    public Rating getRatingById(@PathVariable("id") Long id) {
        return ratingService.getRating(id);
    }

    @GetMapping("/getbyuser/{id}")
    public List<Rating> getUserRatings(@PathVariable("id") Long userId) {
        return ratingService.getRatingByUser(userId);
    }

    @DeleteMapping("/remove")
    public void removeRating(@PathVariable("id") Long ratingId){
        ratingService.removeRating(ratingId);
    }

    @PutMapping("/update")
    public void updateRating(@RequestParam("id") Long ratingId,@RequestParam("details") Long rate){
        ratingService.UpdateRating(ratingId,rate);
    }

    @GetMapping("/averagerating/{id}")
    public double getAverageRating(@PathVariable("id") Long movieId){
        return Double.parseDouble(df.format(ratingService.getAverageRating(movieId)));
    }


}
