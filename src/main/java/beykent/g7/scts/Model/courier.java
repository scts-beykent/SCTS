package beykent.g7.scts.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import scts.Model.packet;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "Couriers")
public class courier {

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
    List<packet> packets;


}
