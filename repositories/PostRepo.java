package com.codewithanup.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithanup.blog.entities.Category;
import com.codewithanup.blog.entities.Post;
import com.codewithanup.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	
}
