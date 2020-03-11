package beykent.g7.scts.Service;

import beykent.g7.scts.Model.adress;
import beykent.g7.scts.Repository.adressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class adressService {

    @Autowired
    adressRepository adressRepository;

    public adress findByAdressId(String adressId){
        return adressRepository.findByAdressId(adressId);
    }

}
