package com.example.moeda.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[EMAIL ENVIADO PARA: " + destinatario + "]\nMensagem: " + mensagem);
    }
}
