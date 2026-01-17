package com.sms.student_management.service;

import com.sms.student_management.dto.StudentRequestDto;
import com.sms.student_management.dto.StudentResponseDto;
import com.sms.student_management.entity.Student;
import com.sms.student_management.exception.StudentNotFoundException;
import com.sms.student_management.mapper.StudentMapper;
import com.sms.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {

        // DTO → Entity
        Student student = studentMapper.toEntity(studentRequestDto);

        // Save to DB
        Student savedStudent = studentRepository.save(student);

        // Entity → Response DTO
        return studentMapper.toResponseDto(savedStudent);
    }


    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponseDto)
                .collect(Collectors.toList());

    }


    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student with id: " + id + " not found"));
        return studentMapper.toResponseDto(student);

    }

    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with id: " + id + " not found"));

        existingStudent.setName(studentRequestDto.getName());
        existingStudent.setEmail(studentRequestDto.getEmail());
        existingStudent.setAge(studentRequestDto.getAge());

        Student savedStudent = studentRepository.save(existingStudent);

        return studentMapper.toResponseDto(savedStudent);


    }

    public void deleteStudent(Long id) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with id: " + id + " not found"));

        studentRepository.delete(existingStudent);
    }


//    public void deleteStudent(Long id) {
//
//        Student existingStudent=getStudentById(id);
//        studentRepository.delete(existingStudent);
//    }
}
