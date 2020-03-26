package beykent.g7.scts.Repository;

import beykent.g7.scts.Model.Packet;
import org.springframework.stereotype.Repository;

@Repository
public interface PacketRepository extends GenericRepository<Packet, String> {

    Packet findByPacketId(String packetId);

}
