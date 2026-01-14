package com.example.blog.service;

import com.example.blog.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IcomentarioService {
    List<Comentario> obtenerPorPosteo(Long posteoId);;

    Optional<Comentario> obtenerPorId(Long id);

    Comentario guardarComentario(Long posteo_id, Comentario comentario);

    Comentario editarComentario(Long comentarioId, Comentario comentarioActualizado);

    void eliminarComentario(Long comentarioId);

}
