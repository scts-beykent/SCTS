package beykent.g7.scts.Service;

import beykent.g7.scts.Model.company;
import beykent.g7.scts.Repository.companyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class companyService {

    @Autowired
    companyRepository companyRepository;

    public company findByCompanyName(String companyName){
        return companyRepository.findByCompanyName(companyName);
    }

}
