package ar.com.xeven.challengedisney.repositories;

import ar.com.xeven.challengedisney.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    List<Character> findCharactersByNameContaining(String name);

    List<Character> findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(String name, Integer age, Movie movie);


    List<Character> findCharactersByNameContainingAndAgeEquals(String name, Integer age);

    List<Character> findCharactersByAgeEquals(Integer age);

    List<Character> findCharactersByNameContainingAndMoviesContaining(String name, Movie movie);

    List<Character> findCharactersByAgeEqualsAndMoviesContaining(Integer age, Movie movie);

    List<Character> findCharactersByMoviesContaining(Movie movie);
}
