package beykent.g7.scts.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Adresses")
public class adress {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "AdressId")
    private String adressId;

    @Column(name = "Adress")
    private String openAdress;


}
