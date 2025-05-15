package com.example.moeda.repository;

import com.example.moeda.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByOrigem(String origem);
    List<Transacao> findByDestino(String destino);
}
