package com.example.blog.service;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.repository.IautorRepository;
import com.example.blog.repository.IposteoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService{

    private final IautorRepository autorRepository;
    private final IposteoRepository iposteoRepository;

    public AutorService(IautorRepository autorRepository, IposteoRepository iposteoRepository) {
        this.autorRepository = autorRepository;
        this.iposteoRepository = iposteoRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Autor> obtenerPorId(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado por id: " + id));

        autor.getPosteos().size();

        return Optional.of(autor);
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no econtrado"));

        autorRepository.delete(autor);
    }

    @Override
    public void editarAutor(Long id, Autor autorActualizado) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new  RuntimeException("Autor no encontrado"));

        autor.setNombre(autorActualizado.getNombre());
        autor.setCorreo(autorActualizado.getCorreo());

        autorRepository.save(autor);
    }

    @Override
    public Autor asignarPosteo(Long autor_id, Posteo posteo) {
        Autor autor = autorRepository.findById(autor_id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        posteo.setAutor(autor);
        autor.getPosteos().add(posteo);

        return autorRepository.save(autor);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Posteo> obtenerPosteosDeAutor(Long autor_id) {
        Autor autor = autorRepository.findById(autor_id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        autor.getPosteos().size();

        return autor.getPosteos();
    }

}
