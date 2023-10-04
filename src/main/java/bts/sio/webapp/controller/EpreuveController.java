package bts.sio.webapp.controller;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.service.EpreuveService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    @GetMapping("/epreuves")
    public String Epreuve(Model model) {
        Iterable<Epreuve> listEpreuves = epreuveService.getEpreuves();
        model.addAttribute("sports", listEpreuves);
        return "sportEpreuves/consulterSportEpreuves";
    }
}
