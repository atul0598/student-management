package com.sms.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private Integer age;
}
