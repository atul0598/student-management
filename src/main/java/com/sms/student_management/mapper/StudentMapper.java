package com.sms.student_management.mapper;

import com.sms.student_management.dto.StudentRequestDto;
import com.sms.student_management.dto.StudentResponseDto;
import com.sms.student_management.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        return student;
    }
    public StudentResponseDto toResponseDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        return dto;
    }


}
