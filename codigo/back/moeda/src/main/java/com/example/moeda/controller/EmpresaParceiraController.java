package com.example.moeda.controller;

import com.example.moeda.model.EmpresaParceira;
import com.example.moeda.repository.EmpresaParceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpresaParceiraController {
    @Autowired
    private EmpresaParceiraRepository repo;

    @GetMapping public List<EmpresaParceira> list() { return repo.findAll(); }
    @PostMapping public EmpresaParceira create(@RequestBody EmpresaParceira e) { return repo.save(e); }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaParceira> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaParceira> update(@PathVariable Long id, @RequestBody EmpresaParceira e) {
        return repo.findById(id).map(atual -> {
            e.setId(id);
            return ResponseEntity.ok(repo.save(e));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}