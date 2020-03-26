package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.Courier;

public interface CourierRepository extends GenericRepository<Courier,String> {
    Courier findByCourierId(int courierId);
}
