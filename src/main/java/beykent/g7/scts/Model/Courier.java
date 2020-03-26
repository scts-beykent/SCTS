package beykent.g7.scts.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourierId")
    private int courierId;

    @Column(name = "CourierName")
    private String courierName;

    @Column(name = "CourierPhoneNumber")
    private String courierPhoneNumber;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "pac_id")
    List<Packet> packets;


}
