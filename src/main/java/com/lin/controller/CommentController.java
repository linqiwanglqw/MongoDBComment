package com.lin.controller;

import com.lin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/{id}")
    public Integer updateCommentLikeNum(@PathVariable String id){
        commentService.updateCommentLikeNum(id);
        Integer likenum = commentService.findCommentById(id).getLikenum();
        return likenum;
    }
}
