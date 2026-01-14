package com.example.blog.controller;

import com.example.blog.model.Comentario;
import com.example.blog.model.Posteo;
import com.example.blog.service.PosteoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PosteoController {

    private final PosteoService posteoService;

    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos() {
        return posteoService.obtenerTodos();
    }

    @PostMapping("/crear")
    public Posteo crearPosteo(@RequestBody Posteo posteo) {
        return posteoService.guardarPost(posteo);
    }

    @GetMapping("/{id}")
    public Posteo obtenerPosteo(@PathVariable Long id) {
        return posteoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));
    }

    @PutMapping("/{id}")
    public Posteo editarPosteo(@PathVariable Long id, @RequestBody Posteo posteoActualizado) {
        posteoService.editarPosteo(id, posteoActualizado);
        return posteoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarPosteo(@PathVariable Long id) {
        posteoService.deletePosteo(id);
    }

    @GetMapping("/{id}/comentarios")
    public List<Comentario> obtenerComentarios(@PathVariable Long id) {
        return posteoService.obtenerComentariosDePosteo(id);
    }
}
