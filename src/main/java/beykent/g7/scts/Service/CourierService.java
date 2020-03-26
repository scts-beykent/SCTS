package beykent.g7.scts.Service;

import beykent.g7.scts.Model.Courier;
import beykent.g7.scts.Repository.CourierRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static beykent.g7.scts.other.SCTSConstant.*;

@Service
@Log
@Transactional
public class CourierService {

    @Autowired
    CourierRepository courierRepository;

    public Courier save(Courier courier){
        try {
            courier =courierRepository.save(courier);
        }catch (Exception e){
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
        }
        return courier;
    }

    public Courier get(int courierId){
        try {
            log.info(String.format(MSG_GET_RECORD, CORUIER,courierId));
            return courierRepository.findByCourierId(courierId);
        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
            return null;
        }
    }


}
