package com.example.moeda.controller;

import com.example.moeda.model.Transacao;
import com.example.moeda.repository.ProfessorRepository;
import com.example.moeda.repository.TransacaoRepository;
import com.example.moeda.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private TransacaoRepository transacaoRepo;

    @Autowired
    private ProfessorRepository professorRepo;

    @PostMapping("/{id}/enviar-moedas")
    public String enviarMoedas(@PathVariable Long id,
                                @RequestParam Long alunoId,
                                @RequestParam int valor,
                                @RequestParam String mensagem) {
        return moedaService.enviarMoedas(id, alunoId, valor, mensagem);
    }

    @GetMapping("/{id}/extrato")
    public List<Transacao> extrato(@PathVariable Long id) {
        String nomeProfessor = professorRepo.findById(id).orElseThrow().getNome();
        return transacaoRepo.findByOrigem(nomeProfessor);
    }
}
