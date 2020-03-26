package beykent.g7.scts.Service;

import beykent.g7.scts.Model.Adress;
import beykent.g7.scts.Repository.AdressRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static beykent.g7.scts.other.SCTSConstant.*;

@Service
@Log
@Transactional
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    public Adress save(Adress adress) {
        try {
            adress= adressRepository.save(adress);
        } catch (Exception e) {

            log.severe(String.format(MSG_ERROR ,e.getMessage()));
        }
        return adress;
    }

    public Adress get(String adressId){
        try {
            log.info(String.format(MSG_GET_RECORD, ADRESS,adressId));
            return adressRepository.findByAdressId(adressId);
        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
            return null;
        }
    }
}
