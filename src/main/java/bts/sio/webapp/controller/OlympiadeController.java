package bts.sio.webapp.controller;

import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Ville;
import bts.sio.webapp.service.OlympiadeService;
import bts.sio.webapp.service.PaysService;
import bts.sio.webapp.service.VilleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class OlympiadeController {
    @Autowired
    private OlympiadeService olympiadeService;
    @Autowired
    private VilleService villeService;

    @GetMapping("/olympiades")
    public String olympiades(Model model) {
        Iterable<Olympiade> listOlympiade = olympiadeService.getLesOlympiades();
        model.addAttribute("olympiades", listOlympiade);
        return "olympiade/listOlympiades";
    }
    @GetMapping("/createOlympiade")
    public String createOlympiade(Model model) {
        Olympiade o = new Olympiade();
        model.addAttribute("olympiade", o);

        Iterable<Ville> listVille = villeService.getVilles();
        model.addAttribute("listVille", listVille);
        return "olympiade/formNewOlympiade";
    }
    @GetMapping("/updateOlympiade/{id}")
    public String updateOlympiade(@PathVariable("id") int id, Model model) {
        Olympiade o = olympiadeService.getOlympiade(id);
        model.addAttribute("olympiade", o);
        return "olympiade/formModifierOlympiade";
    }

    @GetMapping("/deleteOlympiade/{id}")
    public ModelAndView deleteSport(@PathVariable("id") final int id) {
        olympiadeService.deleteOlympiade(id);
        return new ModelAndView("redirect:/olympiades");
    }
    @PostMapping("/saveOlympiade")
    public ModelAndView saveOlympiade(@ModelAttribute Olympiade olympiade) {
        System.out.println("controller save=" + olympiade.getAnnee());
        if(olympiade.getId() != null) {
            Olympiade current = olympiadeService.getOlympiade(olympiade.getId());
        }
        
        olympiadeService.saveOlympiade(olympiade);
        return new ModelAndView("redirect:/olympiades");
    }

}








