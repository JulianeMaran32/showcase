package com.juhmaran.showcase.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
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

    @NotBlank(message = "O nome é obrigatório!")
    @Length(min = 3)
    private String firstName;

    @NotBlank(message = "O sobrenome é obrigatório!")
    @Length(min = 3)
    private String lastName;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "O e-mail é obrigatório!")
    @Column(unique = true)
    private String email;

    @CPF(message = "Insira um número de CPF válido")
    @NotBlank(message = "O número de documento é obrigatório!")
    @Column(unique = true)
    @Size(min = 11, max = 11)
    private String documentNumber;

    @OneToOne
    private Address address;

    @NotBlank(message = "O campo password é obrigatório!")
    @Length(min = 8)
    private String password;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    /**
     * OPÇÕES DE COMO PODE SER IMPLEMENTADO A OPÇÃO ACTIVE
     */

//    @Enumerated(EnumType.STRING)
//    private Status status = Status.ACTIVE;

//    @Builder.Default
//    private boolean active = true;
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

}
