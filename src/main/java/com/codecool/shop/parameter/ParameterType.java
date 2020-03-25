package com.codecool.shop.parameter;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ParameterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parameterTypeId;

    @Column(unique = true,
            nullable = false)
    private String name;

    public ParameterType() {
    }

    public ParameterType(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParameterType)) return false;

        ParameterType that = (ParameterType) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ParameterType{" +
                "parameterTypeId=" + parameterTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}


