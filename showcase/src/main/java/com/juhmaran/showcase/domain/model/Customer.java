package com.juhmaran.showcase.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O campo firstName é obrigatório!")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "O campo lastName é obrigatório!")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "O campo email é obrigatório!")
    @Column(name = "email", unique = true)
    private String email;

    @CPF(message = "Insira um número de CPF válido")
    @NotBlank(message = "O campo documentNumber é obrigatório!")
    @Column(name = "document_number", unique = true)
    private String documentNumber;

    @OneToOne
    private Address address;

    @NotBlank(message = "O campo password é obrigatório!")
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
