package beykent.g7.scts.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CargoCompany")
public class company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "CompanyPhoneNumber")
    private String companyNumber;


}
