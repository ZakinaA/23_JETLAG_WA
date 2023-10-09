package bts.sio.webapp.service;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.repository.EpreuveProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EpreuveService {

    @Autowired
    private EpreuveProxy epreuveRepository;

    public Epreuve getEpreuve(final int id) {
        return epreuveRepository.getEpreuve(id);
    }

    public Iterable<Epreuve> getEpreuves() {
        return epreuveRepository.getEpreuves();
    }

    public void deleteEpreuve(final int id) {
        epreuveRepository.deleteEpreuve(id);
    }

    public Epreuve saveEpreuve(Epreuve epreuve) {
        Epreuve savedEpreuve;

        // Functional rule : Last name must be capitalized.
        epreuve.setLibelle(epreuve.getLibelle().toUpperCase());

        if(epreuve.getId() == null) {
            // If id is null, then it is a new employee.
            savedEpreuve = epreuveRepository.createEpreuve(epreuve);
        } else {
            savedEpreuve = epreuveRepository.updateEpreuve(epreuve);
        }

        return savedEpreuve;
    }

    public Iterable<Epreuve> getEpreuvesBySport_id(Long sport_id) {
        // Appelez la méthode appropriée de votre epreuveRepository pour obtenir les épreuves du sport sélectionné en fonction de sportId.
        return epreuveRepository.getEpreuvesBySport_id(sport_id);
    }

}