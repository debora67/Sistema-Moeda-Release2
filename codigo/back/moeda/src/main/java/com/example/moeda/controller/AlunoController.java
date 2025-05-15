package com.example.moeda.controller;

import com.example.moeda.model.Aluno;
import com.example.moeda.model.Transacao;
import com.example.moeda.repository.AlunoRepository;
import com.example.moeda.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private TransacaoRepository transacaoRepo;

    @Autowired
    private AlunoRepository alunoRepo;

    @GetMapping("/{id}/extrato")
    public List<Transacao> extrato(@PathVariable Long id) {
        Aluno aluno = alunoRepo.findById(id).orElseThrow();
        return transacaoRepo.findByDestino(aluno.getNome());
    }
}
