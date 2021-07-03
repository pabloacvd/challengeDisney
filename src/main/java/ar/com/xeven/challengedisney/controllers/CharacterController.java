package ar.com.xeven.challengedisney.controllers;

import ar.com.xeven.challengedisney.services.CharacterService;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    private List<Map<String,String>> listarPersonajes(){
        return characterService.listarPersonajes();
    }

    @GetMapping("/all")
    private List<Character> listarTodosLosPersonajes(){
        return characterService.listarAllPersonajes();
    }

    @GetMapping("/{id}")
    private Character getPersonajeById(@PathVariable Integer id){
        return characterService.getCharacterById(id);
    }

    @PostMapping(path="/save", consumes = "application/json")
    private void save(@RequestBody Character personaje){
        characterService.save(personaje);
        //TODO sólo actualizar los campos NO NULL
    }

    @DeleteMapping("/borrar/{id}")
    private void borrar(@PathVariable Integer id){
        characterService.delete(id);
    }

}
