package com.example.blog.controller;

import com.example.blog.model.Autor;
import com.example.blog.model.Posteo;
import com.example.blog.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listaAutores() {
        return autorService.obtenerTodos();
    }

    @PostMapping("/crear")
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.guardarAutor(autor);
    }

    @GetMapping("/{id}")
    public Autor obtenerAutor(@PathVariable Long id) {
        return autorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @PutMapping("/{id}")
    public Autor editarAutor(@PathVariable Long id, @RequestBody Autor autorActualizado) {
        autorService.editarAutor(id, autorActualizado);
        return autorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
    }

    // Obtener todos los posteos de un autor
    @GetMapping("/{id}/posteos")
    public List<Posteo> obtenerPosteos(@PathVariable Long id) {
        return autorService.obtenerPosteosDeAutor(id);
    }

    // Asignar un nuevo posteo a un autor
    @PostMapping("/{id}/posteos")
    public Autor asignarPosteo(@PathVariable Long id, @RequestBody Posteo posteo) {
        return autorService.asignarPosteo(id, posteo);
    }
}
