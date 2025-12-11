package com.umbert.flashcash1.repository;

import com.umbert.flashcash1.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    // Ajoute des méthodes personnalisées si nécessaire
}
