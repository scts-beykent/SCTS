package beykent.g7.scts.Controller;

import beykent.g7.scts.Model.Courier;
import beykent.g7.scts.Service.CourierService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static beykent.g7.scts.other.SCTSConstant.*;

@RestController
@RequestMapping("/courier")
@Log
public class CourierController {
    
    @Autowired
    CourierService courierService;


    @PostMapping(path = "/save", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> save(@ModelAttribute Courier courier) {

        Map<String, Object> map = new HashMap<>();
        try {
            courier = courierService.save(courier);
            if (courier != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, SAVE_SUCCESS);
                map.put(CORUIER, courier);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, SAVE_ERROR);
                map.put(CORUIER, courier);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(CORUIER, courier);
        }
        return map;
    }


    @PostMapping(path = "/get", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> get(@RequestParam int courierId) {
        Courier courier = null;
        Map<String, Object> map = new HashMap<>();
        try {
            courier = courierService.get(courierId);
            if (courier != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, REQUEST_SUCCESS);
                map.put(CORUIER, courier);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, ERROR);
                map.put(CORUIER, courier);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(CORUIER, courier);
        }

        return map;
    }
    
    
}
