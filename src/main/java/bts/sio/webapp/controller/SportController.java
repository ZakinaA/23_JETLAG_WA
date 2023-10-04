package bts.sio.webapp.controller;

import bts.sio.webapp.model.Sport;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class SportController {

    @Autowired
    private SportService sportservice;

    @GetMapping("/sports")
    public String Sport(Model model) {
        Iterable<Sport> listSports = sportservice.getSports();
        model.addAttribute("sports", listSports);
        return "formListeSport";
    }
}
