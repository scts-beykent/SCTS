package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.courier;
import scts.Repository.genericRepository;

public interface courierRepository extends genericRepository<courier,String> {
    courier findByCourierName(String courierName);
}
