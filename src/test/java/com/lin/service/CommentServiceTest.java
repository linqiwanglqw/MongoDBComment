package com.lin.service;

import com.lin.pojo.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired CommentService commentService;

    @Test
    public void testFindCommentList(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void testFindCommentById(){
        Comment commentById = commentService.findCommentById("1");
        System.out.println(commentById);
    }

    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("蜡笔3");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1001");
        comment.setNickname("lbxx");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        comment.setPublishtime(LocalDateTime.now());
        comment.setParentid("61f813e766a6a137f10600d6");
        commentService.saveComment(comment);
    }

    @Test
    public void testUpdateComment(){
        Comment comment=new Comment();
        comment.setId("61f80508c595a67831a9f03b");
        comment.setContent("蜡笔小新1");
        commentService.updateComment(comment);
    }

    @Test
    public void testFindCommentListByParentid(){
        Page<Comment> commentListByParentid = commentService.findCommentListByParentid("61f813e766a6a137f10600d6", 1, 2);
        System.out.println(commentListByParentid.getTotalElements());
        System.out.println(commentListByParentid.getContent());
    }
}
