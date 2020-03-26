package beykent.g7.scts.Service;

import beykent.g7.scts.Model.Company;
import beykent.g7.scts.Repository.CompanyRepository;
import beykent.g7.scts.Repository.PacketRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static beykent.g7.scts.other.SCTSConstant.*;

@Service
@Log
@Transactional
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        try {
            company=companyRepository.save(company);
        } catch (Exception e) {

            log.severe(String.format(MSG_ERROR ,e.getMessage()));
        }
        return company;
    }


    public Company get(int companyId){
        try {
            log.info(String.format(MSG_GET_RECORD, COMPANY,companyId));
            return companyRepository.findByCompanyId(companyId);
        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
            return null;
        }
    }

}
