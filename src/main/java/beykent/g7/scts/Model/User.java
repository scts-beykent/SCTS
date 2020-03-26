package beykent.g7.scts.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false, nullable = false , unique=true)
    private int userId;

    private String userName;

    private String userPhoneNumber;

    @OneToMany
    @JoinColumn(name="userAdress")
    List<Adress> userAdresses;

    @OneToMany
    @JoinTable(name="userPacket")
    List<Packet> packets;

}
