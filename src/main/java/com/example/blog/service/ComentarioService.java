package com.example.blog.service;

import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IcomentarioRepository;
import com.example.blog.repository.IposteoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComentarioService implements IcomentarioService {

    private final IcomentarioRepository comentarioRepository;
    private final IposteoRepository posteoRepository;

    public ComentarioService(IcomentarioRepository comentarioRepository, IposteoRepository posteoRepository) {
        this.comentarioRepository = comentarioRepository;
        this.posteoRepository = posteoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comentario> obtenerPorPosteo(Long posteo_id) {
        Posteo posteo = posteoRepository.findById(posteo_id).orElseThrow(() -> new RuntimeException("Posteo no encontrado"));
        posteo.getComentarios().size();

        return posteo.getComentarios();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comentario> obtenerPorId(Long id) {

        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario guardarComentario(Long posteo_id, Comentario comentario) {
        Posteo posteo = posteoRepository.findById(posteo_id).orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        comentario.setPosteo(posteo);
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comentario editarComentario(Long comentario_id, Comentario comentarioActualizado) {
        Comentario comentarioExistente = comentarioRepository.findById(comentario_id).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comentarioExistente.setTexto(comentarioActualizado.getTexto());

        return comentarioRepository.save(comentarioExistente);
    }

    @Override
    public void eliminarComentario(Long comentario_id) {
        Comentario comentario = comentarioRepository.findById(comentario_id).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        comentarioRepository.delete(comentario);
    }

    public Comentario asociarComentarioALPosteo(Long posteo_id, Long comentario_id) {
        Posteo posteo = posteoRepository.findById(posteo_id).orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        Comentario comentario = comentarioRepository.findById(comentario_id).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comentario.setPosteo(posteo);
        return comentarioRepository.save(comentario);
    }
}