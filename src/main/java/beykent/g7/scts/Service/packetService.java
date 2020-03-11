package beykent.g7.scts.Service;

import beykent.g7.scts.Model.packet;
import beykent.g7.scts.Repository.packetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class packetService {

    @Autowired
    packetRepository packetRepository;

    public packet findByPacketId(String packetId){
        return packetRepository.findByPacketId(packetId);
    }

}
