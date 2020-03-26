package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, String> {

    User findByUserId(int userId);

}
