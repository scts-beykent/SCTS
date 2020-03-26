package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.Adress;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends GenericRepository<Adress,String> {

    Adress findByAdressId(String adressId);

}
