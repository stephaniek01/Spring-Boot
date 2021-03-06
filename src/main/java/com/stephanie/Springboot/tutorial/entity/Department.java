package com.stephanie.Springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add a department name")
    @Length(min = 3, max = 10, message = "Department name should be between 3-10 characters")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    /* Other validators
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    */
}
