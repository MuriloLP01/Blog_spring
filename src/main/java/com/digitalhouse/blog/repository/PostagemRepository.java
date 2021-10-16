package com.digitalhouse.blog.repository;

import com.digitalhouse.blog.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

    public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);
}
