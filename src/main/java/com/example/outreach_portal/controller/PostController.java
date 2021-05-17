package com.example.outreach_portal.controller;

import java.util.List;

import com.example.outreach_portal.bean.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.outreach_portal.JSONEntity.CommentJson;
import com.example.outreach_portal.JSONEntity.FriendJson;
import com.example.outreach_portal.JSONEntity.LikeJson;
import com.example.outreach_portal.JSONEntity.PostJson;
import com.example.outreach_portal.bean.Comment;
import com.example.outreach_portal.bean.Post;
import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.service.PostService;

@CrossOrigin(origins="*")
@RestController
public class PostController {

	Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@PostMapping(path="/createPost")
	public ResponseEntity<?> createPost(@RequestBody PostJson post)
	{
		try
		{
			logger.info("Create post");
			int post_id=this.postService.createPost(post);
			return new ResponseEntity<>(post_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path="/viewPost")
	public ResponseEntity<?> viewPost(@RequestBody String post_id)
	{
		try
		{
			logger.info("View post");

			Post post = this.postService.getPost(Integer.parseInt(post_id));

			return new ResponseEntity<>(post,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PostMapping(path="/getUserPost")
	public ResponseEntity<?> getuserPost(@RequestBody String user_id)
	{
		try
		{
			logger.info("Get post");

			List<Post> post = this.postService.viewPost(Integer.parseInt(user_id));

			return new ResponseEntity<>(post,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path="/getAllPost")
	public ResponseEntity<?> getAllPost()
	{
		try
		{
			logger.info("Get all post");

			List<Post> post = this.postService.viewAllPost();

			return new ResponseEntity<>(post,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PostMapping(path="/likePost")
	public ResponseEntity<?> likePost(@RequestBody LikeJson likeJson)
	{
		try
		{
			logger.info("Like post");

			this.postService.like(likeJson);

			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path="/commentPost")
	public ResponseEntity<?> commentPost(@RequestBody CommentJson commentJson)
	{
		try
		{
			logger.info("Comment post");

			this.postService.comment(commentJson);

			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@GetMapping(path="/getLike/{post_id}")
	public ResponseEntity<?> getLike(@PathVariable String post_id)
	{
		try
		{
			logger.info("Get like of post");

			List<User> usr=this.postService.viewLike(Integer.parseInt(post_id));

			return new ResponseEntity<>(usr,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path="/getComment/{post_id}")
	public ResponseEntity<?> getComment(@PathVariable String post_id)
	{
		try
		{
			logger.info("Get comment of post");

			List<Comment> cmt=this.postService.viewComment(Integer.parseInt(post_id));

			return new ResponseEntity<>(cmt,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}







}
