package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IautorService {
    List<Autor> obtenerTodos();

    Optional<Autor> obtenerPorId(Long id);

    Autor guardarAutor(Autor autor);

    //Metodo para eliminar posteo
    void deleteAutor(Long id);

    //Metodo para editar una posteo
    void editarAutor(Long id, Autor autorActualizado);

    // Metodo para asignar Posteo
    Autor asignarPosteo(Long autor_id, Posteo posteo);

    List<Posteo> obtenerPosteosDeAutor(Long autor_id);
}
