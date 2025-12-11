package com.umbert.flashcash1.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    private List<Link> links;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Save account automaticly
    @JoinColumn(name = "account_account_id", referencedColumnName = "accountId") // Column name on the table
    private UserAccount account;

}
