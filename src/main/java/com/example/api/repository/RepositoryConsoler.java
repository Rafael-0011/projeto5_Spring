package com.example.api.repository;

import com.example.api.model.Console;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConsoler extends JpaRepository<Console, Long> {

}
