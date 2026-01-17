package com.sms.student_management.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
}
