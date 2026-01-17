package com.sms.student_management.dto;

public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
