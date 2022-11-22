package com.example.commentsservice.repository;


import com.example.commentsservice.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comments,Long> {
    List<Comments> findAllByUserId(Long userID);
}
