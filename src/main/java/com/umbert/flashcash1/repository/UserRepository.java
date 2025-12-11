package com.umbert.flashcash1.repository;

import com.umbert.flashcash1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Recherche par email (utile pour l'authentification)
    Optional<User> findByEmail(String email);

    // Vérifier si un email existe déjà
    boolean existsByEmail(String email);

    // Recherche par nom et prénom
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    // Recherche par IBAN du compte
    @Query("SELECT u FROM User u WHERE u.account.iban = :iban")
    Optional<User> findByAccountIban(@Param("iban") String iban);

    // Trouver tous les utilisateurs avec un solde supérieur à un montant
    @Query("SELECT u FROM User u WHERE u.account.amount >= :minAmount")
    List<User> findUsersWithMinAmount(@Param("minAmount") double minAmount);

    // Trouver tous les utilisateurs avec un solde inférieur à un montant
    @Query("SELECT u FROM User u WHERE u.account.amount < :maxAmount")
    List<User> findUsersWithLowBalance(@Param("maxAmount") double maxAmount);

    // Trouver un utilisateur par accountId
    @Query("SELECT u FROM User u WHERE u.account.accountId = :accountId")
    Optional<User> findByAccountId(@Param("accountId") Integer accountId);
}
