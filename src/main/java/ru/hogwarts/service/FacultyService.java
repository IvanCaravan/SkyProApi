package ru.hogwarts.service;

import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(Long id);

    Faculty updateFaculty(Long id, Faculty faculty);

    void removeFaculty(Long id);

    Collection<Faculty> getAll();

    Collection<Faculty> getAllByColor(String color);

    Collection<Student> getStudentsByFaculty(Faculty faculty);
}
