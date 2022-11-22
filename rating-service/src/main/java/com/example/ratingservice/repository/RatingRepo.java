package com.example.ratingservice.repository;


import com.example.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RatingRepo extends CrudRepository<Rating,Long> {
    List<Rating> findAllByUserId(Long userID);
    @Query("select avg(r.rate) from Rating r where r.movieId = ?1")
    double getAverageRating(Long movieId);
}
