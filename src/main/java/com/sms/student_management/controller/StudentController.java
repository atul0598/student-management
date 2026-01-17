package com.sms.student_management.controller;

import com.sms.student_management.dto.StudentRequestDto;
import com.sms.student_management.dto.StudentResponseDto;
import com.sms.student_management.student.StudentService;
import com.sms.student_management.entity.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @PostMapping("/students")
//    public Student createStudent(@Valid @RequestBody Student student){
//        return studentService.createStudent(student);
//    }
    
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto saveStudent =studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id) {
        StudentResponseDto student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }


    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto studentRequestDto) {

        StudentResponseDto updatedStudent =
                studentService.updateStudent(id, studentRequestDto);

        return ResponseEntity.ok(updatedStudent);
    }


//    @PutMapping("students/{id}")
//    public Student updateStudent(@PathVariable Long  id, @Valid @RequestBody Student updatedStudent){
//        return studentService.updateStudent(id,updatedStudent);
//    }

//    @DeleteMapping("/students/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return "Student deleted Successfully";
//    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
