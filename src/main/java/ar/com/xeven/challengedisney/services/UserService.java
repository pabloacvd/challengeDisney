package ar.com.xeven.challengedisney.services;

import ar.com.xeven.challengedisney.entities.User;
import ar.com.xeven.challengedisney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String save(User user) {
        if(userRepository.existsByNameOrEmail(user.getName(), user.getEmail()))
            return "Usuario existente";

        int num = (int) (Math.random()*100)+1;
        user.setToken(user.getName()+num);
        user.setApiCallsLimit(1000);
        user.setApiCallsAvailable(1000);
        userRepository.save(user);
        return user.getToken();
    }

    public String login(String email, String token) {
        User user = userRepository.findUserByEmailAndToken(email, token);
        if(user != null){
            user.setTokenTemporal(String.valueOf((Math.round(Math.random()*100000)+1)));
            userRepository.save(user);
            return user.getTokenTemporal();
        }
        return "Error de acceso";
    }
}
