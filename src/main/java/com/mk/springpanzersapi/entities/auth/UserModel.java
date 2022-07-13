package com.mk.springpanzersapi.entities.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mk.springpanzersapi.entities.CharacteristicsPlayer;
import com.mk.springpanzersapi.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nickname"),
                @UniqueConstraint(columnNames = "email")
        })
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 15)
    private String nickname;

    @NotBlank
    @Size(max = 20)
    private String password;

    @NotBlank
    @Size(max = 120)
    private String token;

    @NotBlank
    @Size(max = 120)
    private String avatarUrl;

    @NotBlank
    private boolean status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @PrimaryKeyJoinColumn
    private CharacteristicsPlayer characteristicsPlayer;

    public UserModel(String nickname, String email, String password,
                     String token, String avatarUrl) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.token = token;
        this.avatarUrl = avatarUrl;
    }
}

