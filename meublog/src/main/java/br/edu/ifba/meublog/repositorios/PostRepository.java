package br.edu.ifba.meublog.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifba.meublog.entidades.Post;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{

	public List<Post> findByTitulo(String titulo);
}
