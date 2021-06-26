package ar.com.xeven.challengedisney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    List<Character> findCharactersByNameContaining(String name);

}
