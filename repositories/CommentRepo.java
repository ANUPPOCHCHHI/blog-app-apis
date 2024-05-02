package com.codewithanup.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithanup.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
