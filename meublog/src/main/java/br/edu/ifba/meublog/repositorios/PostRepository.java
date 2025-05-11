package br.edu.ifba.meublog.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.meublog.entidades.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
