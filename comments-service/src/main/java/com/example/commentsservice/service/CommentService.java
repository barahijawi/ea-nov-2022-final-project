package com.example.commentsservice.service;

import com.example.commentsservice.entity.Comments;

import java.util.List;

public interface CommentService {
    void addComment(Comments comment);
    void removeComment(Long id);
    Comments getComment(Long id);
    void UpdateComment(Long commentID,String details);

    List<Comments> getCommentByUser(Long userId);
}
