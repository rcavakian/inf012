package br.edu.ifba.meublog.dtos;

import br.edu.ifba.meublog.entidades.Categoria;
import br.edu.ifba.meublog.entidades.Usuario;

public record PostForm(Long id, String titulo, String texto, Usuario usuario, Categoria categoria) {

}
