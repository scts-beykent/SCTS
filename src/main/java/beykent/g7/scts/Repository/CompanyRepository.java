package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends GenericRepository<Company,String> {

    Company findByCompanyId(int companyId);

}
