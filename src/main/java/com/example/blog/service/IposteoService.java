package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);
    Posteo guardarPost(Posteo posteo);
//Metodo para eliminar posteo
    void deletePosteo(Long id);
//Metodo para editar una posteo
    void editarPosteo(Long id, Posteo posteoActualizado);
    // Metodo para obtener todos los comentarios de un posteo
    List<Comentario> obtenerComentariosDePosteo(Long post_id);
}
