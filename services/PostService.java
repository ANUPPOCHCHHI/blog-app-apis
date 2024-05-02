package com.codewithanup.blog.services;

import java.util.List;

import com.codewithanup.blog.entities.Post;
import com.codewithanup.blog.payloads.PostDto;
import com.codewithanup.blog.payloads.PostResponse;

public interface PostService {
	
	//create 
	
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//gel all posts
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
	
}
