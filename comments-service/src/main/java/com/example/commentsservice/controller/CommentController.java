package com.example.commentsservice.controller;

import com.example.commentsservice.entity.Comments;
import com.example.commentsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class CommentController {

    CommentService commentService;

    @PostMapping("/add")
    public void addComment(@RequestBody Comments comment) {
        commentService.addComment(comment);
    }

    @GetMapping("/getbyid")
    public Comments getCommentById(@PathVariable("id") Long id) {
        return commentService.getComment(id);
    }

    @GetMapping("/getbyuser/{id}")
    public List<Comments> getUserComments(@PathVariable("id") Long userId) {
        return commentService.getCommentByUser(userId);
    }

    @DeleteMapping("/remove")
    public void removeComment(@PathVariable("id") Long commentId){
        commentService.removeComment(commentId);
    }

    @PutMapping("/update")
    public void updateComment(@RequestParam("id") Long commentId,@RequestParam("details") String details){
        commentService.UpdateComment(commentId,details);
    }

}
