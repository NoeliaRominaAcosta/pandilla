package com.api.pandilla.services;

import com.api.pandilla.models.Donation;
import com.api.pandilla.models.Expense;
import com.api.pandilla.models.Family;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.repositories.DonationRepository;
import com.api.pandilla.repositories.ExpenseRepository;
import com.api.pandilla.repositories.IFamilyRepository;
import com.api.pandilla.repositories.IPetRepository;
import dto.DonationDTO;
import dto.ExpenseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialService {

    private final ExpenseRepository expenseRepository;
    private final DonationRepository donationRepository;
    private final IPetRepository petRepository;
    private final IFamilyRepository familyRepository;

    // Crear un gasto
    public Expense createExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setType(expenseDTO.getType());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        expense.setDescription(expenseDTO.getDescription());

        if (expenseDTO.getPetId() != null) {
            PetModel pet = petRepository.findById(expenseDTO.getPetId())
                    .orElseThrow(() -> new IllegalArgumentException("Pet not found"));
            expense.setPet(pet);
        }

        return expenseRepository.save(expense);
    }

    // Crear una donación
    public Donation createDonation(DonationDTO donationDTO) {
        Donation donation = new Donation();
        donation.setAmount(donationDTO.getAmount());
        donation.setDate(donationDTO.getDate());
        donation.setDescription(donationDTO.getDescription());

        if (donationDTO.getFamilyId() != null) {
            Family family = familyRepository.findById(donationDTO.getFamilyId())
                    .orElseThrow(() -> new IllegalArgumentException("Family not found"));
            donation.setFamily(family);
        }

        return donationRepository.save(donation);
    }

    // Obtener todos los gastos
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Obtener todas las donaciones
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    // Obtener los gastos por mascota (si aplica)
    public List<Expense> getExpensesByPetId(Long petId) {
        return expenseRepository.findByPetId(petId);
    }

    // Obtener donaciones por familia adoptante
    public List<Donation> getDonationsByFamilyId(Long familyId) {
        return donationRepository.findByFamilyId(familyId);
    }
}
