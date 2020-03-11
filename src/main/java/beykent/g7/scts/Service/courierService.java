package beykent.g7.scts.Service;

import beykent.g7.scts.Model.courier;
import beykent.g7.scts.Repository.courierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class courierService {

    @Autowired
    courierRepository courierRepository;

    public courier findByCourierName(String courierName){
        return courierRepository.findByCourierName(courierName);
    }

}
