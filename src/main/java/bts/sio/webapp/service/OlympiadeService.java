package bts.sio.webapp.service;


import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.repository.OlympiadeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class OlympiadeService {
    @Autowired
    private OlympiadeProxy olympiadeProxy;
    public Olympiade getOlympiade(final int id) {
        return olympiadeProxy.getOlympiade(id);
    }

    public Iterable<Olympiade> getLesOlympiades() {return olympiadeProxy.getLesOlympiades();
    }


    public void deleteOlympiade(final int id) {
        olympiadeProxy.deleteOlympiade(id);
    }

    public Olympiade saveOlympiade(Olympiade olympiade) {
        Olympiade savedOlympiade;

        olympiade.setNumero(olympiade.getNumero());
        olympiade.setAnnee(olympiade.getAnnee());
        olympiade.setVille(olympiade.getVille());

        if(olympiade.getId() == null) {
            // If id is null, then it is a new employee.
            savedOlympiade = olympiadeProxy.createOlympiade(olympiade);
        } else {
            savedOlympiade = olympiadeProxy.updateOlympiade(olympiade);
        }

        return savedOlympiade;
    }


}