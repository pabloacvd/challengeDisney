package ar.com.xeven.challengedisney.controllers;

import ar.com.xeven.challengedisney.services.CharacterService;
import ar.com.xeven.challengedisney.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/images")
    private List<Map<String,String>> listarPersonajes(@RequestParam Optional<String> token){
        return (tokenEsValido(token))?characterService.listarPersonajes():null;
    }

    private boolean tokenEsValido(Optional<String> token) {
        if(token.isPresent())
        //    return userService.validateToken(token.get());
            return true;
        return false;
    }

    @GetMapping("/all")
    private List<Character> listarTodosLosPersonajes(){
        return characterService.listarAllPersonajes();
    }

    @GetMapping("/{id}")
    private Character getPersonajeById(@PathVariable Integer id){
        return characterService.getCharacterById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    private List<Character> buscar(@RequestParam Optional<String> name,
            @RequestParam Optional<Integer> age, @RequestParam Optional<Integer> movies){
        return characterService.findCharacters(name, age, movies);
    }

    @PostMapping(path="/save", consumes = "application/json")
    private void save(@RequestBody Character personaje){
        characterService.save(personaje);
    }

    @DeleteMapping("/borrar/{id}")
    private void borrar(@PathVariable Integer id){
        characterService.delete(id);
    }

}
