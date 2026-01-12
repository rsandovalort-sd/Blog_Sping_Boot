package com.example.blog.controller;


import com.example.blog.model.Posteo;
import com.example.blog.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PosteoController {
    private final PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService){
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos(){
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id){
        return posteoService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarPersona(@RequestBody Posteo posteo){
        posteoService.guardarPost(posteo);
        return ResponseEntity.ok("Post agregado con éxito");
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deletePosteo(@PathVariable Long id){
        posteoService.deletePosteo(id);
        return ResponseEntity.ok("Posteo eliminado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarPosteo(@PathVariable Long id, @RequestBody Posteo posteoActualizado){
        posteoService.editarPosteo(id, posteoActualizado);
        return ResponseEntity.ok("Posteo actualizado con éxito");
    }



}
