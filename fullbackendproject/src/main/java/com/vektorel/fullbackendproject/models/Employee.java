package com.vektorel.fullbackendproject.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Employee", description = "Employee Entity Class")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType = "Long", name = "id", notes = "Employee classinin id propertysi")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @ApiModelProperty(dataType = "String", name = "name", value = "50", notes = "Name propertysi. 50 karakter alir.")
    private String name;

    @Column(name = "surnamename", length = 50, nullable = false)
    @ApiModelProperty(dataType = "String", name = "surname", value = "50", notes = "surname propertysi. 50 karakter alir.")
    private String surname;

    @Column(name = "email", length = 75, nullable = false)
    @ApiModelProperty(dataType = "String", name = "email", value = "75", notes = "Email propertysi. 75 karakter alir.")
    private String email;

    @Column(name = "department", length = 50, nullable = false)
    @ApiModelProperty(dataType = "String", name = "department", value = "50", notes = "Department propertysi. 50 karakter alir.")
    private String department;

    @Column(name = "title", length = 50)
    @ApiModelProperty(dataType = "String", name = "title", value = "50", notes = "title propertysi. 50 karakter alir.")
    private String title;

    @Column(name = "identityNumber", length = 11, unique = true, updatable = false, nullable = false)
    @ApiModelProperty(dataType = "String", name = "titidentityNumber", value = "11", notes = "identityNumber propertysi. 11 karakter alir. updatable = false")
    private String identityNumber;

}
