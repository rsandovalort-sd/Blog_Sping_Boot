package com.example.blog.service;

import com.example.blog.model.Comentario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComentarioService implements IcomentarioService {

    @Override
    public List<Comentario> obtenerPorPosteo(Long posteoId) {
        return List.of();
    }

    @Override
    public Optional<Comentario> obtenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardarComentario(Comentario comentario) {

    }

    @Override
    public Comentario editarComentario(Long comentarioId, Comentario comentarioActualizado) {
        return null;
    }

    @Override
    public void eliminarComentario(Long comentarioId) {

    }
}