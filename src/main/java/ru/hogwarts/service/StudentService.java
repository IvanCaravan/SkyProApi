package ru.hogwarts.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.model.Avatar;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;

import java.io.IOException;
import java.util.Collection;

public interface StudentService {

    Student createStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);

    void removeStudent(Long id);

    Collection<Student> getAll();

    Collection<Student> getAllByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    Faculty getFacultyByStudent(Student student);

}
