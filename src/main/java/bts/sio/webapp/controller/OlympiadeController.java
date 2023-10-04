package bts.sio.webapp.controller;

import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.service.OlympiadeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class OlympiadeController {
    @Autowired
    private OlympiadeService olympiadeService;

    @GetMapping("/olympiade")
    public String olympiade(Model model) {
        Iterable<Olympiade> listOlympiade = olympiadeService.getLesOlympiades();
        model.addAttribute("olympiades", listOlympiade);
        return "olympiade/formOlympiade";
    }
}