package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.company;
import org.springframework.stereotype.Repository;

@Repository
public interface companyRepository extends genericRepository<company,String> {

    company findByCompanyName(String companyName);

}
