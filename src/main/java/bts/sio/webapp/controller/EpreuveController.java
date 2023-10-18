package bts.sio.webapp.controller;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.model.Ville;
import bts.sio.webapp.service.EpreuveService;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Data
@Controller
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @GetMapping("/createSportEpreuve")
    public String createSportEpreuve(@RequestParam(name = "sport_id") Long sport_id,
                            Model model) {
        Epreuve epreuve = new Epreuve();
        Sport s = new Sport();
        s.setId(sport_id);
        epreuve.setSport(s);

        model.addAttribute("epreuve", epreuve);
        model.addAttribute("sport_id", sport_id);
        return "sportEpreuves/formNewSportEpreuve";
    }

    @PostMapping("/saveEpreuve")
    public ModelAndView saveEpreuve(@ModelAttribute Epreuve epreuve) {
        System.out.println("controller save=" + epreuve.getLibelle());
        if(epreuve.getId() != null) {
            Epreuve current = epreuveService.getEpreuve(epreuve.getId());
        }
        epreuveService.saveEpreuve(epreuve);
        return new ModelAndView("redirect:/sports");
    }
    @GetMapping("/updateEpreuve/{id}")
    public String updateEpreuve(@PathVariable("id") int id, Model model) {
        Epreuve e = epreuveService.getEpreuve(id);
        model.addAttribute("epreuve", e);


        return "sportEpreuves/formModifSportEpreuve";
    }

    @GetMapping("/deleteEpreuve/{id}")
    public ModelAndView deleteEpreuve(@PathVariable("id") final int id) {
        epreuveService.deleteEpreuve(id);
        return new ModelAndView("redirect:/sports");
    }

    @GetMapping("/epreuves")
    public String Epreuve(@RequestParam(name = "sport_id") Long sport_id,
                          @RequestParam(name = "sportName") String sportName,
                          Model model) {
        // Utilisez sportId pour récupérer les épreuves du sport sélectionné depuis le service
        Iterable<Epreuve> listEpreuves = epreuveService.getEpreuvesBySport_id(sport_id);
        model.addAttribute("epreuves", listEpreuves);
        model.addAttribute("sportName", sportName); // Ajoutez le nom du sport au modèle
        return "sportEpreuves/consulterSportEpreuves";
    }
}
