package beykent.g7.scts.Service;

import beykent.g7.scts.Model.Packet;
import beykent.g7.scts.Repository.PacketRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import static beykent.g7.scts.other.SCTSConstant.*;

@Service
@Transactional
@Log
public class PacketService {

    @Autowired
    PacketRepository packetRepository;

    public Packet save(Packet packet) {
        try {
            packet=packetRepository.save(packet);
        } catch (Exception e) {

            log.severe(String.format(MSG_ERROR ,e.getMessage()));
        }
        return packet;
    }


    public Packet get(String packetId){
        try {
            log.info(String.format(MSG_GET_RECORD, PACKET,packetId));
            return packetRepository.findByPacketId(packetId);
        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR ,e.getMessage()));
            return null;
        }
    }

}
