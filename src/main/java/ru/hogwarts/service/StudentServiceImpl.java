package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.exception.StudentNotFoundException;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.StudentRepository;
import java.util.Collection;
import ru.hogwarts.repository.AvatarRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;



    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = getStudent(id);
        existing.setName(student.getName());
        return studentRepository.save(existing);
    }


    @Override
    public void removeStudent(Long id) {
        studentRepository.existsById(id);
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getAllByAge(int age) {
        return studentRepository.getAllByAge(age);
    }

    @Override
    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFacultyByStudent(Student student) {
        return student.getFaculty();
    }

}
