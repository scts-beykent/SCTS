package beykent.g7.scts.Controller;

import beykent.g7.scts.Model.Adress;
import beykent.g7.scts.Model.Company;
import beykent.g7.scts.Service.AdressService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static beykent.g7.scts.other.SCTSConstant.*;

@RestController
@RequestMapping("/adress")
@Log
public class AdressController {

    @Autowired
    AdressService adressService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> save(@ModelAttribute Adress adress) {

        Map<String, Object> map = new HashMap<>();
        try {
            adress = adressService.save(adress);
            if (adress != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, SAVE_SUCCESS);
                map.put(ADRESS, adress);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, SAVE_ERROR);
                map.put(ADRESS, adress);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(ADRESS, adress);
        }
        return map;
    }


    @PostMapping(path = "/get", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> get(@RequestParam String adressId) {
        Adress adress = null;
        Map<String, Object> map = new HashMap<>();
        try {
            adress = adressService.get(adressId);
            if (adress != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, REQUEST_SUCCESS);
                map.put(ADRESS, adress);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, ERROR);
                map.put(ADRESS, adress);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(ADRESS, adress);
        }

        return map;
    }


}
