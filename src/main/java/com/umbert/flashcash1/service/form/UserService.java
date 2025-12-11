package com.umbert.flashcash1.service.form;

import com.umbert.flashcash1.model.User;
import com.umbert.flashcash1.model.UserAccount;
import com.umbert.flashcash1.repository.UserAccountRepository;
import com.umbert.flashcash1.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
    public class UserService {
    private final SessionService sessionService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;

    public UserService(SessionService sessionService, PasswordEncoder passwordEncoder, UserRepository userRepository, UserAccountRepository userAccountRepository) {
        this.sessionService = sessionService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Transactional
    public User registration(SignUpForm form) {

        System.out.println(">>> Début registration");

        // Vérification email déjà utilisé
        userRepository.findByEmail(form.getEmail()).ifPresent(u -> {
            System.out.println(">>> Email déjà utilisé : " + form.getEmail());
            throw new RuntimeException("Email déjà utilisé");
        });

        // Vérification mot de passe / confirmation
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            System.out.println(">>> Mot de passe et confirmation différents");
            throw new RuntimeException("Les mots de passe ne correspondent pas");
        }

        // Création du compte utilisateur
        System.out.println(">>> Création UserAccount");
        UserAccount account = new UserAccount();
        account.setAmount(0.0);
        account.setIban(null);

        // Création du user
        System.out.println(">>> Création User");
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setAccount(account);

        // Enregistrement
        System.out.println(">>> Sauvegarde user en DB...");
        User saved = userRepository.save(user);

        System.out.println(">>> User sauvegardé avec ID = " + saved.getId());
        System.out.println(">>> Account sauvegardé avec ID = " + saved.getAccount().getAccountId());

        return saved;
    }
}



