package com.example.api.repository;

import com.example.api.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor,Long> {
}
