package com.codecool.shop.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Setter
@Getter
@Table(schema = "public")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String emailAddress;

    @Column
    private String phoneNumber;

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
}
