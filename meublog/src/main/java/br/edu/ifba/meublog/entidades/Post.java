package br.edu.ifba.meublog.entidades;

import br.edu.ifba.meublog.dtos.PostDTO;
import br.edu.ifba.meublog.dtos.PostForm;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String texto;
	@ManyToOne
	private Usuario usuario;
	@Enumerated(EnumType.STRING)
	private Categoria categoria = Categoria.COTIDIANO;

	public Post() {

	}

	public Post(String titulo, String texto, Usuario usuario, Categoria categoria) {
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.categoria = categoria;
	}
	
	public Post(PostForm postForm) {
		this.id = postForm.id();
		this.titulo = postForm.titulo();
		this.texto = postForm.texto();
		this.categoria = postForm.categoria();
		this.usuario = postForm.usuario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
