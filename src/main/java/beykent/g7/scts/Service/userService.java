package beykent.g7.scts.Service;

import beykent.g7.scts.Model.user;
import beykent.g7.scts.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class userService {

    @Autowired
    userRepository userRepository;

    public user findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

}
