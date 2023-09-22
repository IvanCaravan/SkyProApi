package ru.hogwarts.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.model.Avatar;
@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Long> {
    Optional<Avatar> findByStudentId(Long studentId);

}
