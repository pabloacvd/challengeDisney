package ar.com.xeven.challengedisney.controllers;

import ar.com.xeven.challengedisney.services.CharacterService;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    private List<Character> listarPersonajes(){
        return characterService.listarPersonajes();
    }

    @PostMapping(path="/save",consumes = "application/json")
    private void save(@RequestBody Character personaje){
        characterService.save(personaje);
    }


}
