package beykent.g7.scts.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "Users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false, nullable = false , unique=true)
    private int userId;

    private String userName;

    private String userPhoneNumber;

    @OneToMany
    @JoinColumn(name="userAdress")
    List<adress> userAdresses;

    @OneToMany
    @JoinTable(name="userPacket")
    List<packet> packets;

}
