package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.adress;
import org.springframework.stereotype.Repository;

@Repository
public interface adressRepository extends genericRepository<adress,String> {

    adress findByAdressId(String adressId);

}
