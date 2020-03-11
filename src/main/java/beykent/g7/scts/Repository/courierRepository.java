package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.courier;

public interface courierRepository extends genericRepository<courier,String> {
    courier findByCourierName(String courierName);
}
