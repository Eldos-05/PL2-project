package comsep_23.Textile_Industry_Production.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<comsep_23.Textile_Industry_Production.entity.User> findByLogin(String login); // Changed to findByLogin
}
