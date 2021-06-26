package ar.com.xeven.challengedisney.repositories;

import ar.com.xeven.challengedisney.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
