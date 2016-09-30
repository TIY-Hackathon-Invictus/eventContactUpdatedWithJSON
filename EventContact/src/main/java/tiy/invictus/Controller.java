package tiy.invictus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 9/30/2016.
 */
public class Controller {

    @Autowired
    EventRepository events;
    @Autowired
    UserRepository users;

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.email = "Zach@hunter.com";
            user.password = "hunter2";
            users.save(user);
        }
    }
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String home(Model model, HttpSession session) {

        return "home";
    }
}
