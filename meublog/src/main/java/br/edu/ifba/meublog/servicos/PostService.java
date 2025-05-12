package br.edu.ifba.meublog.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifba.meublog.dtos.PostDTO;
import br.edu.ifba.meublog.dtos.PostForm;
import br.edu.ifba.meublog.entidades.Post;
import br.edu.ifba.meublog.repositorios.PostRepository;
import br.edu.ifba.meublog.repositorios.UsuarioRepository;

@Service
public class PostService {
	
    private PostRepository postRepository;
    private UsuarioRepository usuarioRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostForm cadastrar(PostForm postForm) {
        Post post = this.postRepository.save(new Post(postForm));
        return new PostForm(post.getId(), post.getTitulo(), post.getTexto(), post.getUsuario(), post.getCategoria());
    }
    
    public List<PostDTO> listar() {
    	return this.postRepository.findAll().stream().map(PostDTO::new).toList();
    }
    
    public PostDTO deletar(Long id) {
    	Post post = this.postRepository.findById(id).orElse(null);
    	if (post != null) {
    		this.postRepository.delete(post);
    		return new PostDTO(post);
    	}
    	return null;
    }
}
