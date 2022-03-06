package com.student.registration.studentregistration.Controller;

import com.student.registration.studentregistration.Domain.Student;
import com.student.registration.studentregistration.Request.StudentRequestModel;
import com.student.registration.studentregistration.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();     // ALL records, no pagination implemented
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {

        if( studentService.getStudentById( Long.valueOf(id) ).isPresent() ) {
            return new ResponseEntity<>(
                    studentService.getStudentById( Long.valueOf(id) ).get(),
                    HttpStatus.ACCEPTED
            );
        }
        else {
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/students/{city}")     //path var "city"
    public ResponseEntity< List<Student> > getStudentsInCity(@PathVariable String city) {

        List<Student> students = studentService.getStudentsByCity(city);

        if(students.size() > 0) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping( consumes = { MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<Student> add(@Valid @RequestBody StudentRequestModel student) {

        return new ResponseEntity<>(
                studentService.saveStudent(student),
                HttpStatus.OK
        );
    }


    @PutMapping( path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE },
                                        produces = {MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<Student> updateStudent(@PathVariable String id,
                                                    @Valid @RequestBody StudentRequestModel student) {

        if( studentService.getStudentById( Long.valueOf(id) ).isPresent() ) {

            return new ResponseEntity<>
                    ( studentService.updateStudent(student, Long.valueOf(id)),
                            HttpStatus.ACCEPTED
                    );
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
            //this endpoint just returns a plain response entity to send response status & message to the client

            studentService.deleteStudent(Long.valueOf(id));

            return ResponseEntity.noContent().build();
    }

}
