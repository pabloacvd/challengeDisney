package ar.com.xeven.challengedisney.services;

import ar.com.xeven.challengedisney.repositories.CharacterRepository;
import ar.com.xeven.challengedisney.entities.Character;
import ar.com.xeven.challengedisney.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    public List<Map<String,String>> listarPersonajes() {
        List<Map<String,String>> lista = new ArrayList<>();
        for(Character personaje : characterRepository.findAll())
            lista.add(Map.of("name", personaje.getName(), "image_url", personaje.getImage_url()));
        return lista;
    }

    public void save(Character personaje) {
        characterRepository.save(personaje);
    }

    public void delete(Integer id) {
        characterRepository.deleteById(id);
    }

    public List<Character> listarAllPersonajes() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Integer id) {
        Character personaje = characterRepository.findById(id).orElse(null);
/*
        if(personaje!=null)
            personaje.setMovies(movieRepository.findMoviesByCharactersEquals(personaje)); // TODO agregar pelis

 */
        return personaje;
    }
}
