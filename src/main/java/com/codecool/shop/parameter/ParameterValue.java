package com.codecool.shop.parameter;

import com.codecool.shop.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

//todo make it look in JSON like {"26", "diameter"}, instead of "_26"
//todo or {"surface": "hardpack"}
@Data
@Entity
@Table(schema = "public",
        name = "parameter_value",
        uniqueConstraints = @UniqueConstraint(columnNames = {"parameter_type_id", "parameter_value"}))
public class ParameterValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parameterValueId;

    @ManyToOne
    @JoinColumn(name = "parameter_type_id")
    private ParameterType type;

    @Column(name = "parameter_value")
    private String parameterValue;

    @ManyToMany(mappedBy = "parameters",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonIgnore
    Set<Product> products;

    public ParameterValue() {
    }


    public ParameterValue(ParameterType parameterType, String parameterValue) {
        this.type = parameterType;
        this.parameterValue = parameterValue;
    }

    public boolean equals(String parameterTypeName, String parameterValue) {
        return this.parameterValue.equals(parameterValue)
                && type.getName().equals(parameterTypeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParameterValue)) return false;

        ParameterValue that = (ParameterValue) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return parameterValue != null ? parameterValue.equals(that.parameterValue) : that.parameterValue == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (parameterValue != null ? parameterValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParameterValue{" +
                "parameterValueId=" + parameterValueId +
                ", type=" + type +
                ", parameterValue='" + parameterValue + '\'' +
                '}';
    }


}
