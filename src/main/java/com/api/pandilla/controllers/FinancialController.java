package com.api.pandilla.controllers;

import com.api.pandilla.models.Donation;
import com.api.pandilla.models.Expense;
import com.api.pandilla.services.FinancialService;
import dto.DonationDTO;
import dto.ExpenseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial")
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
public class FinancialController {

    private final FinancialService financialService;

    // Crear un gasto
    @PostMapping("/expenses")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense expense = financialService.createExpense(expenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }

    // Crear una donación
    @PostMapping("/donations")
    public ResponseEntity<Donation> createDonation(@RequestBody DonationDTO donationDTO) {
        Donation donation = financialService.createDonation(donationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(donation);
    }

    // Obtener todos los gastos
    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = financialService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    // Obtener todas las donaciones
    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = financialService.getAllDonations();
        return ResponseEntity.ok(donations);
    }
}

