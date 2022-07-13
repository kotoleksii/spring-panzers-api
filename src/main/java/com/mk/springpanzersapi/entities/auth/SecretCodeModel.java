package com.mk.springpanzersapi.entities.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "secretCodes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
        })
public class SecretCodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 6)
    private String code;

    public SecretCodeModel(String code, String email) {
        this.email = email;
        this.code = code;
    }
}
