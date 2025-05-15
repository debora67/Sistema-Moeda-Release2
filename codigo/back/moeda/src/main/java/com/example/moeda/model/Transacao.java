package com.example.moeda.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origem;
    private String destino;
    private int valor;
    private String mensagem;
    private LocalDateTime dataHora;

    public Transacao() {}

    public Transacao(String origem, String destino, int valor, String mensagem) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.mensagem = mensagem;
        this.dataHora = LocalDateTime.now();
    }

}
