package com.api.pandilla.repositories;

import com.api.pandilla.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByPetId(Long petId);  // Buscar gastos por mascota
}