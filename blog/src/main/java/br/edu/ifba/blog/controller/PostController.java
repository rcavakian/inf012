package br.edu.ifba.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.blog.entidades.Post;

@RestController
public class PostController {
	@RequestMapping("/posts")
	@GetMapping
	public Post listar() {
		Post post = new Post();
		post.setTitulo("Novo título...");
		return post;
	}
}
