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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("/sports")
    public String Sport(Model model) {
        Iterable<Sport> listSports = sportService.getSports();
        model.addAttribute("sports", listSports);
        return "sport/listeSport";
    }

    @GetMapping("/createSport")
    public String createSport(Model model) {
        Sport a = new Sport();
        model.addAttribute("sport", a);

        return "sport/formNewSport";
    }
    @GetMapping("/updateSport/{id}")
    public String updateSport(@PathVariable("id") final int id, Model model) {
        Sport s = sportService.getSport(id);
        model.addAttribute("sport", s);
        return "sport/formModifierSport";
    }

    @GetMapping("/deleteSport/{id}")
    public ModelAndView deleteSport(@PathVariable("id") final int id) {
        sportService.deleteSport(id);
        return new ModelAndView("redirect:/sports");
    }
    @PostMapping("/saveSport")
    public ModelAndView saveSport(@ModelAttribute Sport sport) {
        System.out.println("controller save=" + sport.getDescriptif());
        if(sport.getId() != null) {
            Sport current = sportService.getSport(sport.getId());
        }
        sportService.saveSport(sport);
        return new ModelAndView("redirect:/sports");
    }

    @GetMapping("/sports/olympiade")
    public String Sport(@RequestParam(name = "olympiade_id") Long olympiade_id,
                        @RequestParam(name = "olympiadeAnnee") String olympiadeAnnee,
                        Model model) {
        Iterable<Sport> listSports = sportService.getSportsByOlympiade_id(olympiade_id);
        model.addAttribute("sports", listSports);
        model.addAttribute("olympiadeAnnee", olympiadeAnnee); // Ajoutez le nom du sport au modèle
        return "olympiadeSports/consulterOlympiadeSports";
    }


}