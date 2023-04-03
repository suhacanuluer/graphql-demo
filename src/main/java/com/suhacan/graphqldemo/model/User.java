package com.suhacan.graphqldemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "_user")
public class User extends BaseEntity {

    private String username;
    private String mail;

    @Enumerated(EnumType.STRING)
    private Role role;
}
