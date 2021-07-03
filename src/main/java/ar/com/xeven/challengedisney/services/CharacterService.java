package ar.com.xeven.challengedisney.services;

import ar.com.xeven.challengedisney.entities.Movie;
import ar.com.xeven.challengedisney.repositories.CharacterRepository;
import ar.com.xeven.challengedisney.entities.Character;
import ar.com.xeven.challengedisney.repositories.MovieRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Character save(Character character) {
        if(character.getCharacter_id()!=null) {
            Character personajeExistente = characterRepository.findById(character.getCharacter_id()).orElse(null);
            if (personajeExistente != null) {
                if (character.getName() != null) personajeExistente.setName(character.getName());
                if (character.getAge() != null) personajeExistente.setAge(character.getAge());
                if (character.getImage_url() != null) personajeExistente.setImage_url(character.getImage_url());
                if (character.getStory() != null) personajeExistente.setStory(character.getStory());
                if (character.getWeight() != null) personajeExistente.setWeight(character.getWeight());
                return characterRepository.save(personajeExistente);
            }else character.setCharacter_id(null);
        }
        return (character.estoyBienFormado())?characterRepository.save(character):null;
    }

    public void delete(Integer id) {
        characterRepository.deleteById(id);
    }

    public List<Character> listarAllPersonajes() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Integer id) {
        Character personaje = characterRepository.findById(id).orElse(null);
        return personaje;
    }

    public List<Character> findCharacters(Optional<String> name, Optional<Integer> age, Optional<Integer> movies) {
        try{
            if(movies.isPresent()) {
                Movie movie = movieRepository.findById(movies.get()).orElseThrow(Exception::new);
                if(name.isPresent() && age.isPresent())
                    return characterRepository.findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(name.get(), age.get(), movie);
                else if(name.isPresent())
                    return characterRepository.findCharactersByNameContainingAndMoviesContaining(name.get(), movie);
                else if(age.isPresent())
                    return characterRepository.findCharactersByAgeEqualsAndMoviesContaining(age.get(), movie);
                else
                    return characterRepository.findCharactersByMoviesContaining(movie);
            }else {
                if(name.isPresent() && age.isPresent())
                    return characterRepository.findCharactersByNameContainingAndAgeEquals(name.get(), age.get());
                else if(name.isPresent())
                    return characterRepository.findCharactersByNameContaining(name.get());
                else if(age.isPresent())
                    return characterRepository.findCharactersByAgeEquals(age.get());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
