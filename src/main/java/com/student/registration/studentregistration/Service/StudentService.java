package com.student.registration.studentregistration.Service;

import com.student.registration.studentregistration.Domain.Student;
import com.student.registration.studentregistration.Request.StudentRequestModel;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(StudentRequestModel student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudentById(Long id);
    public List<Student> getStudentsByCity(String city);
    public Student updateStudent(StudentRequestModel student, Long id);
    public void deleteStudent(Long id);
}
