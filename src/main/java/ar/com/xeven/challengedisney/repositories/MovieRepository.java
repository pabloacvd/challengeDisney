package ar.com.xeven.challengedisney.repositories;

import ar.com.xeven.challengedisney.entities.Movie;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMoviesByCharactersEquals(Character personaje);

}
