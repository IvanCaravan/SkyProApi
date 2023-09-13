package ru.hogwarts.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.model.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar,Long> {
    Optional<Avatar> findByStudentId(Long studentId);

}
