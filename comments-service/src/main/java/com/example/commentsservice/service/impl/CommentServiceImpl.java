package com.example.commentsservice.service.impl;

import com.example.commentsservice.entity.Comments;
import com.example.commentsservice.repository.CommentRepo;
import com.example.commentsservice.service.CommentService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    CommentRepo commentRepo;

    @Override
    public void addComment(Comments comment) {
        commentRepo.save(comment);
    }

    @Override
    public void removeComment(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comments getComment(Long id) {
         var comment =commentRepo.findById(id);
        return comment.orElseGet(Comments::new);
    }

    @Override
    public void UpdateComment(Long commentId,String details) {
        var comment = commentRepo.findById(commentId);
        if(comment.isPresent())
        {
            Comments commentUpdate = comment.get();
            commentUpdate.setDetails(details);
            commentRepo.save(commentUpdate);
        }
    }

    @Override
    public List<Comments> getCommentByUser(Long userId) {
        return commentRepo.findAllByUserId(userId);
    }
}
