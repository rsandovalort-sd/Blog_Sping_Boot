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

    @GetMapping("/posteo/{posteo_id}")
    public List<Comentario> obtenerPorPosteo(@PathVariable Long posteo_id) {
        return comentarioService.obtenerPorPosteo(posteo_id);
    }

    @GetMapping("/{id}")
    public Comentario obtenerComentario(@PathVariable Long id) {
        return comentarioService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    @PostMapping("/posteo/{posteo_id}")
    public Comentario crearComentario(@PathVariable Long posteo_id, @RequestBody Comentario comentario) {
        return comentarioService.guardarComentario(posteo_id, comentario);
    }

    @PutMapping("/{id}")
    public Comentario editarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActualizado) {
        return comentarioService.editarComentario(id, comentarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
    }

    @PostMapping("/{comentario_id}/posteo/{posteo_id}")
    public Comentario asociarComentario(@PathVariable Long comentario_id, @PathVariable Long posteo_id) {
        return comentarioService.asociarComentarioALPosteo(posteo_id, comentario_id);
    }
}
