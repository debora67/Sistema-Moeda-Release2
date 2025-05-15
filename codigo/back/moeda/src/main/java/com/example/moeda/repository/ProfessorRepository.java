package com.example.moeda.repository;

import com.example.moeda.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Métodos customizados, se precisar, podem ser adicionados aqui
}

