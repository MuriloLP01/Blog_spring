package com.digitalhouse.blog.Controller;


import com.digitalhouse.blog.Model.Tema;
import com.digitalhouse.blog.Repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("descricao/{descricao}")
    public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
