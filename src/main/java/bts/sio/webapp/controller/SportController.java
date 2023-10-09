package bts.sio.webapp.controller;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Pays;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.service.OlympiadeService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class SportController {

    @Autowired
    private SportService sportservice;

    @GetMapping("/sports")
    public String Sport(Model model) {
        Iterable<Sport> listSports = sportservice.getSports();
        model.addAttribute("sports", listSports);
        return "sport/listeSport";
    }

    @GetMapping("/createSport")
    public String createSport(Model model) {
        Sport a = new Sport();
        model.addAttribute("sport", a);

        return "sport/formNewSport";
    }

    @GetMapping("/deleteSport/{id}")
    public ModelAndView deleteSport(@PathVariable("id") final int id) {
        sportservice.deleteSport(id);
        return new ModelAndView("redirect:/sports");
    }
}