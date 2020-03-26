package beykent.g7.scts.Controller;

import beykent.g7.scts.Model.Company;
import beykent.g7.scts.Service.CompanyService;
import beykent.g7.scts.Service.PacketService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static beykent.g7.scts.other.SCTSConstant.*;

@RestController
@RequestMapping("/company")
@Log
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> save(@ModelAttribute Company company) {

        Map<String, Object> map = new HashMap<>();
        try {
            company = companyService.save(company);
            if (company != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, SAVE_SUCCESS);
                map.put(COMPANY, company);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, SAVE_ERROR);
                map.put(COMPANY, company);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(COMPANY, company);
        }
        return map;
    }


    @PostMapping(path = "/get", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> get(@RequestParam int companyId) {
        Company company = null;
        Map<String, Object> map = new HashMap<>();
        try {
            company = companyService.get(companyId);
            if (company != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, REQUEST_SUCCESS);
                map.put(COMPANY, company);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, ERROR);
                map.put(COMPANY, company);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(COMPANY, company);
        }

        return map;
    }


}
