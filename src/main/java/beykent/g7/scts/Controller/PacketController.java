package beykent.g7.scts.Controller;

import beykent.g7.scts.Model.Packet;
import beykent.g7.scts.Service.PacketService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static beykent.g7.scts.other.SCTSConstant.*;

@RestController
    @RequestMapping("/packet")
@Log
    public class PacketController {

        @Autowired
        PacketService packetService;

        @PostMapping(path = "save", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
        public Map<String, Object> save(@ModelAttribute Packet packet) {

            Map<String, Object> map = new HashMap<>();
            try {
                packet = packetService.save(packet);
                if (packet != null) {
                    map.put(STATUS, SUCCESS);
                    map.put(MESSAGE, SAVE_SUCCESS);
                    map.put(PACKET, packet);
                } else {
                    map.put(STATUS, ERROR);
                    map.put(MESSAGE, SAVE_ERROR);
                    map.put(PACKET, packet);
                }

            } catch (Exception e) {
                log.severe(String.format(MSG_ERROR, e.getMessage()));
                map.put(STATUS, ERROR);
                map.put(MESSAGE, e.getMessage());
                map.put(PACKET, packet);
            }
            return map;
        }


        @PostMapping(path = "/get", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
        public Map<String, Object> get(@RequestParam String packetId) {
            Packet packet = null;
            Map<String, Object> map = new HashMap<>();
            try {
                packet = packetService.get(packetId);
                if (packet != null) {
                    map.put(STATUS, SUCCESS);
                    map.put(MESSAGE, REQUEST_SUCCESS);
                    map.put(PACKET, packet);
                } else {
                    map.put(STATUS, ERROR);
                    map.put(MESSAGE, ERROR);
                    map.put(PACKET, packet);
                }

            } catch (Exception e) {
                log.severe(String.format(MSG_ERROR, e.getMessage()));
                map.put(STATUS, ERROR);
                map.put(MESSAGE, e.getMessage());
                map.put(PACKET, packet);
            }

            return map;
        }


    }
