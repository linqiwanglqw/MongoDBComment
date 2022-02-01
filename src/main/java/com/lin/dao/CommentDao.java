package com.lin.dao;


import com.lin.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDao extends MongoRepository<Comment,String> {

    //自定义方法,方法名不能乱写,parentid为pojo内的上级ID 根据上级ID查询文章评论的分页列表
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
