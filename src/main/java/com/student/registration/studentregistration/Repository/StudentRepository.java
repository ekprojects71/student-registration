package com.student.registration.studentregistration.Repository;

import com.student.registration.studentregistration.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCityIgnoreCase(String city);
}
