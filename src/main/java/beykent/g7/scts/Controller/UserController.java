package beykent.g7.scts.Controller;

import beykent.g7.scts.Model.User;
import beykent.g7.scts.Service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static beykent.g7.scts.other.SCTSConstant.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Log
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "save", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> save(@ModelAttribute User user) {

        Map<String, Object> map = new HashMap<>();
        try {
            user = userService.save(user);
            if (user != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, SAVE_SUCCESS);
                map.put(USER, user);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, SAVE_ERROR);
                map.put(USER, user);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(USER, user);
        }
        return map;
    }


    @PostMapping(path = "/get", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Map<String, Object> get(@RequestParam int userId) {
        User user = null;
        Map<String, Object> map = new HashMap<>();
        try {
            user = userService.get(userId);
            if (user != null) {
                map.put(STATUS, SUCCESS);
                map.put(MESSAGE, REQUEST_SUCCESS);
                map.put(USER, user);
            } else {
                map.put(STATUS, ERROR);
                map.put(MESSAGE, ERROR);
                map.put(USER, user);
            }

        } catch (Exception e) {
            log.severe(String.format(MSG_ERROR, e.getMessage()));
            map.put(STATUS, ERROR);
            map.put(MESSAGE, e.getMessage());
            map.put(USER, user);
        }

        return map;
    }




}
