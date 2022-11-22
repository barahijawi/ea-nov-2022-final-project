package com.example.ratingservice.service;

import com.example.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {
    void addRating(Rating rate);
    void removeRating(Long id);
    Rating getRating(Long id);
    void UpdateRating(Long commentID,Long details);

    List<Rating> getRatingByUser(Long userId);

    double getAverageRating(Long movieId);
}
