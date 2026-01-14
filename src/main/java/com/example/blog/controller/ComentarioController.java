package com.example.blog.controller;

import com.example.blog.model.Comentario;
import com.example.blog.service.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping("/posteo/{posteoId}")
    public List<Comentario> obtenerPorPosteo(@PathVariable Long posteoId) {
        return comentarioService.obtenerPorPosteo(posteoId);
    }

    @GetMapping("/{id}")
    public Comentario obtenerComentario(@PathVariable Long id) {
        return comentarioService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    @PostMapping("/posteo/{posteoId}")
    public Comentario crearComentario(@PathVariable Long posteoId, @RequestBody Comentario comentario) {
        return comentarioService.guardarComentario(posteoId, comentario);
    }

    @PutMapping("/{id}")
    public Comentario editarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActualizado) {
        return comentarioService.editarComentario(id, comentarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
    }

    @PostMapping("/{comentarioId}/posteo/{posteoId}")
    public Comentario asociarComentario(@PathVariable Long comentarioId, @PathVariable Long posteoId) {
        return comentarioService.asociarComentarioALPosteo(posteoId, comentarioId);
    }
}
