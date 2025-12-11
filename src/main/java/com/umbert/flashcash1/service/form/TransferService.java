package com.umbert.flashcash1.service.form;

import com.umbert.flashcash1.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    public List<Transfer> findTransactions() {
        // TODO: Implémenter la logique pour récupérer les transactions
        return List.of(); // Retourne une liste vide pour l'instant
    }
}