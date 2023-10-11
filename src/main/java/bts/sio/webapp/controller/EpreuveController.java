package bts.sio.webapp.controller;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.service.EpreuveService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Data
@Controller
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

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
