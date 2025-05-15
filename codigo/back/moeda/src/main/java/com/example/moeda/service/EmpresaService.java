package com.example.moeda.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.moeda.model.EmpresaParceira;
import com.example.moeda.repository.EmpresaParceiraRepository;

@Service
public class EmpresaService {
    private final EmpresaParceiraRepository empresaRepository;

    public EmpresaService(EmpresaParceiraRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaParceira salvar(EmpresaParceira empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaParceira> listarTodas() {
        return empresaRepository.findAll();
    }

    public EmpresaParceira buscarPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }
}
