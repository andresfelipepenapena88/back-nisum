package co.com.nisum.user.userRegistry.repository;

import co.com.nisum.user.userRegistry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE email = ?1")
    List<User> findByEmail(String email);
}
