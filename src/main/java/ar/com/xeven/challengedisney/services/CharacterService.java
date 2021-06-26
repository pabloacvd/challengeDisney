package ar.com.xeven.challengedisney.services;

import ar.com.xeven.challengedisney.repositories.CharacterRepository;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> listarPersonajes() {
        List<Character> personajes = characterRepository.findAll();

        return personajes;
    }

    public void save(Character personaje) {
        characterRepository.save(personaje);
    }
}
