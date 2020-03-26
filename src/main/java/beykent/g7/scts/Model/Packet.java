package beykent.g7.scts.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "Packets")
public class Packet {

    @Id
    @Column(name = "PacketId")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String packetId;

    @Column(name = "PacketType")
    private String packetType;

    @Column(name = "PacketWeight")
    private double packetWeight;




}
