package beykent.g7.scts.Service;

import beykent.g7.scts.Model.User;
import beykent.g7.scts.Repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static beykent.g7.scts.other.SCTSConstant.*;
import javax.transaction.Transactional;

@Service
@Log
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        try {
            user= userRepository.save(user);
        } catch (Exception e) {

            log.severe(String.format(MSG_ERROR ,e.getMessage()));
        }
        return user;
    }

    public User get(int userId){
        try {
            log.info(String.format(MSG_GET_RECORD, USER,userId));
            return userRepository.findByUserId(userId);
        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
            return null;
        }
    }

}
