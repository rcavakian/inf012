package br.edu.ifba.meublog.controles;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.meublog.dtos.PostDTO;
import br.edu.ifba.meublog.dtos.PostForm;
import br.edu.ifba.meublog.entidades.Post;
import br.edu.ifba.meublog.entidades.Usuario;
import br.edu.ifba.meublog.repositorios.PostRepository;
import br.edu.ifba.meublog.repositorios.UsuarioRepository;
import br.edu.ifba.meublog.servicos.UsuarioService;
import br.edu.ifba.meublog.servicos.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostRepository postRepository;
	private UsuarioRepository usuarioRepository;

	private PostService postService;
	private UsuarioService usuarioService;
	
	public PostController(PostRepository postRepository, UsuarioService usuarioService) {
		this.postRepository = postRepository;
		this.usuarioService = usuarioService;
	}
	
	
	@PostMapping
	public ResponseEntity<PostForm> criarPost(@RequestBody PostForm postForm) {
		PostForm form = this.postService.cadastrar(postForm);
		Usuario usuario = this.usuarioService.buscarPorNome(null);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		post.setUsuario(usuario);
		this.postRepository.save(post);
		return ResponseEntity.ok(new PostDTO(post));
	}
	
	@GetMapping
	public List<Post> listarPosts() {
		return this.postRepository.findAll();
	}

}
