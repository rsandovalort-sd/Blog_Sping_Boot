package com.example.blog.service;

import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IcomentarioRepository;
import com.example.blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService {
    private final IposteoRepository posteoRepository;
    private final IcomentarioRepository comentarioRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository, IcomentarioRepository comentarioRepository){
        this.posteoRepository = posteoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        Posteo posteo = posteoRepository.findById(id).orElseThrow(() -> new RuntimeException("Posteo no encontrado por id: " + id));

        posteo.getComentarios().size();

        return Optional.of(posteo);
    }

    @Override
    public Posteo guardarPost(Posteo posteo) {
        posteoRepository.save(posteo);
        return posteo;
    }

    @Override
    public void deletePosteo(Long id) {
        Posteo posteo = posteoRepository.findById(id).orElseThrow(() -> new RuntimeException("Posteo no econtrado"));

        posteoRepository.delete(posteo);
    }

    @Override
    public void editarPosteo(Long id, Posteo posteoActualizado) {
        Posteo posteoExistente = posteoRepository.findById(id).orElse(null);

        if(posteoExistente != null){
            posteoExistente.setTitulo(posteoActualizado.getTitulo());
            posteoExistente.setContenido(posteoActualizado.getContenido());

            posteoRepository.save(posteoExistente);
        }else {
            throw new RuntimeException("Posteo no encontrado por id: " + id);
        }
    }


    @Transactional(readOnly = true)
    @Override
    public List<Comentario> obtenerComentariosDePosteo(Long post_id) {
        Posteo posteo = posteoRepository.findById(post_id).orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        posteo.getComentarios().size();

        return posteo.getComentarios();
    }


}
