package com.example.moeda.service;

import com.example.moeda.model.Aluno;
import com.example.moeda.model.Professor;
import com.example.moeda.model.Transacao;
import com.example.moeda.repository.AlunoRepository;
import com.example.moeda.repository.ProfessorRepository;
import com.example.moeda.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoedaService {

    @Autowired
    private ProfessorRepository professorRepo;

    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private TransacaoRepository transacaoRepo;

    @Autowired
    private EmailService emailService;

    public String enviarMoedas(Long idProfessor, Long idAluno, int valor, String mensagem) {
        Professor professor = professorRepo.findById(idProfessor).orElseThrow();
        Aluno aluno = alunoRepo.findById(idAluno).orElseThrow();

        if (professor.getSaldo() < valor) {
            return "Saldo insuficiente.";
        }

        professor.setSaldo(professor.getSaldo() - valor);
        aluno.setSaldo(aluno.getSaldo() + valor);
        professorRepo.save(professor);
        alunoRepo.save(aluno);

        Transacao transacao = new Transacao(professor.getNome(), aluno.getNome(), valor, mensagem);
        transacaoRepo.save(transacao);

        emailService.enviar(aluno.getEmail(), "Você recebeu " + valor + " moedas de " + professor.getNome() + "\nMotivo: " + mensagem);
        return "Moedas enviadas com sucesso.";
    }
}
