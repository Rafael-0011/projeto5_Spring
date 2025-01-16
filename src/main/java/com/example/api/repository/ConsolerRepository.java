package com.example.api.repository;

import com.example.api.model.Console;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsolerRepository extends JpaRepository<Console, Long> {
    List<Console> findByIdIn(List<Long> ids);

}
