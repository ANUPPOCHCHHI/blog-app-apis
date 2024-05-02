package com.codewithanup.blog.services;

import com.codewithanup.blog.payloads.CommentDto;

public interface CommentService {
	
		
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
