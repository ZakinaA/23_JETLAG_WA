package bts.sio.webapp.service;

import bts.sio.webapp.model.Sport;
import bts.sio.webapp.repository.SportProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SportService {

    @Autowired
    private SportProxy sportProxy;

    public Sport getSport(final Long id) {
        return sportProxy.getSport(id);
    }

    public Iterable<Sport> getSports() {
        return sportProxy.getSports();
    }

    public void deleteSport(final Long id) {
        sportProxy.deleteSport(id);
    }

    public Sport saveSport(Sport sport) {
        Sport savedSport;

        // Functional rule : Last name must be capitalized.
        sport.setNom(sport.getNom().toUpperCase());
        sport.setDescriptif(sport.getDescriptif());
        sport.setNomImage(sport.getNomImage());

        if(sport.getId() == null) {
            // If id is null, then it is a new employee.
            savedSport = sportProxy.createSport(sport);
        } else {
            savedSport = sportProxy.updateSport(sport);
        }

        return savedSport;
    }

    public Iterable<Sport> getSportsByOlympiade_id(Long olympiade_id) {
        // Appelez la méthode appropriée de votre epreuveRepository pour obtenir les épreuves du sport sélectionné en fonction de sportId.
        return sportProxy.getSportsByOlympiade_id(olympiade_id);
    }
}