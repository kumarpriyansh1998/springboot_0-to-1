package com.priyansh.code.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class employeeDto {

    private Long Id;
    @NotNull(message="Name cannot be null")
    @NotEmpty
    @NotBlank
    @Size(min = 4,max = 10)
    private String name;
    @Min(value = 20)
    private String age;
    private LocalDate date;

    @JsonProperty("isActive")
    @AssertTrue(message ="Employee should be active")
    private Boolean isActive;

    @Positive
    private String salary;

    @Pattern(regexp = "^(ADMIN|USER)$")
    private String role;

    @PastOrPresent
    private LocalDate dateOfJoining;
}
