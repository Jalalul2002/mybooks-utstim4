package id.ac.uinsgd.student.projectUTS.projectUTS.repository;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
