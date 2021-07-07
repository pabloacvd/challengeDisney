package ar.com.xeven.challengedisney.repositories;

import ar.com.xeven.challengedisney.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByNameOrEmail(String name, String email);

    User findUserByEmailAndToken(String email, String token);

}
