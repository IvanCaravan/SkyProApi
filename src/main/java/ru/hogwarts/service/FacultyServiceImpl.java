package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.exception.FacultyNotFoundException;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.repository.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElseThrow(()-> new FacultyNotFoundException("Faculty not found"));
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existing = getFaculty(id);
        existing.setName(faculty.getName());
        existing.setColor(faculty.getColor());
        return facultyRepository.save(existing);
    }

    @Override
    public void removeFaculty(Long id) {
        facultyRepository.existsById(id);
    }

    @Override
    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> getAllByColor(String color) {
//  return getAll().stream().filter(f->f.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
        return facultyRepository.getAllByColor(color);
    }

    

}