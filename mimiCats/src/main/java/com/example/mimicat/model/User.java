package com.example.mimicat.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    public enum Role {
        ADMIN, USER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String login;

    private String hashPassword;
}
