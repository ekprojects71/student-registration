package com.student.registration.studentregistration.Service;

import com.student.registration.studentregistration.Domain.Student;
import com.student.registration.studentregistration.Repository.StudentRepository;
import com.student.registration.studentregistration.Request.StudentRequestModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(StudentRequestModel student) {

        Student incomingStudent = new Student();
        incomingStudent.setFirstName( student.getFirstName() );
        incomingStudent.setLastName( student.getLastName() );
        incomingStudent.setStreetAddress( student.getStreetAddress() );
        incomingStudent.setCity( student.getCity() );
        incomingStudent.setState( student.getState() );
        incomingStudent.setZipcode( student.getZipcode() );

        return studentRepository.save( incomingStudent );
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsByCity(String city) {
        return studentRepository.findAllByCityIgnoreCase(city);
    }

    @Override
    public Student updateStudent(StudentRequestModel student, Long id) {

        Student storedStudent = getStudentById( Long.valueOf(id) ).get();
        storedStudent.setFirstName (student.getFirstName() );
        storedStudent.setLastName( student.getLastName() );
        storedStudent.setStreetAddress( student.getStreetAddress() );
        storedStudent.setCity( student.getCity() );
        storedStudent.setState( student.getState() );
        storedStudent.setZipcode( student.getZipcode() );

        return studentRepository.save(storedStudent);  //update record in DB
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
