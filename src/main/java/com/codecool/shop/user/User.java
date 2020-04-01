package com.codecool.shop.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Component
@Entity
@Table(schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true)
    @NotEmpty
    private String name;

    @Column(unique = true)
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

}
