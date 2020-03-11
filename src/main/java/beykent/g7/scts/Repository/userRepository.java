package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.user;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends genericRepository<user, String> {

    user findByUserName(String userName);

}
