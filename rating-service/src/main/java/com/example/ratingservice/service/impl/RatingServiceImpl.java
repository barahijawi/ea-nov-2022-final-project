package com.example.ratingservice.service.impl;

import com.example.ratingservice.entity.Rating;
import com.example.ratingservice.repository.RatingRepo;
import com.example.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    RatingRepo ratingRepo;

    @Override
    public void addRating(Rating comment) {
        ratingRepo.save(comment);
    }

    @Override
    public void removeRating(Long id) {
        ratingRepo.deleteById(id);
    }

    @Override
    public Rating getRating(Long id) {
         var comment = ratingRepo.findById(id);
        return comment.orElseGet(Rating::new);
    }

    @Override
    public void UpdateRating(Long rateId,Long rate) {
        var rating = ratingRepo.findById(rateId);
        if(rating.isPresent())
        {
            Rating rateUpdate = rating.get();
            rateUpdate.setRate(rate);
            ratingRepo.save(rateUpdate);
        }
    }

    @Override
    public List<Rating> getRatingByUser(Long userId) {
        return ratingRepo.findAllByUserId(userId);
    }

    @Override
    public double getAverageRating(Long movieId) {
        return ratingRepo.getAverageRating(movieId);
    }
}
