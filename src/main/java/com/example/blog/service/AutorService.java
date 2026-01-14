package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IautorRepository;

import java.util.List;
import java.util.Optional;

public class AutorService implements IautorService{

    private final IautorRepository autorRepository;

    public AutorService(IautorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return List.of();
    }

    @Override
    public Optional<Autor> obtenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardarAutor(Autor autor) {

    }

    @Override
    public void deleteAutor(Long id) {

    }

    @Override
    public void editarAutor(Long id, Autor autorActualizado) {

    }

    @Override
    public Autor agregarPosteo(Long autorId, Posteo posteo) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));




        return autorRepository.save(autor);
    }
}
