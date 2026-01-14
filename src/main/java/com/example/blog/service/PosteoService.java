package com.example.blog.service;

import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PosteoService implements IposteoService {
    private final IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository){
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        Posteo posteo = posteoRepository.findById(id).orElseThrow();




        return Optional.of(posteo);
    }

    @Override
    public void guardarPost(Posteo posteo) {
        posteoRepository.save(posteo);
    }

    @Override
    public void deletePosteo(Long id) {
        posteoRepository.deleteById(id);
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

    @Override
    @Transactional
    public Posteo agregarComentario(Long posteoId, Comentario comentario) {

        Posteo posteo = posteoRepository.findById(posteoId)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        comentario.setPosteo(posteo

    }


}
