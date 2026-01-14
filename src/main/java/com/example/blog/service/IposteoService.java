package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import org.hibernate.graph.CannotBecomeEntityGraphException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);
    void guardarPost(Posteo posteo);
//Metodo para eliminar posteo
    void deletePosteo(Long id);
//Metodo para editar una posteo
    void editarPosteo(Long id, Posteo posteoActualizado);
    // Metodo para agregar Posteo
    Posteo agregarComentario(Long posteoId, Comentario comentario);
}
