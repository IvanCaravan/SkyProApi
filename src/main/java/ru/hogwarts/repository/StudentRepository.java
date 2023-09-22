package ru.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.model.Student;

import java.util.Collection;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> getAllByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

}
