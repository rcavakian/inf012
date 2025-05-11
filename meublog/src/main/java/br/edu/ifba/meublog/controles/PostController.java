package br.edu.ifba.meublog.controles;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.meublog.dtos.PostDTO;
import br.edu.ifba.meublog.entidades.Post;
import br.edu.ifba.meublog.entidades.Usuario;
import br.edu.ifba.meublog.repositorios.PostRepository;
import br.edu.ifba.meublog.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostRepository postRepository;
	private UsuarioRepository usuarioRepository;
	public PostController(PostRepository postRepository, UsuarioRepository usuarioRepository) {
		this.postRepository = postRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	
	@PostMapping
	public ResponseEntity<PostDTO> criarPost(@RequestBody PostDTO postDTO) {
		Post post = new Post(postDTO);
		Usuario usuario = this.usuarioRepository.findByNome(postDTO.nomeUsuario());
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
