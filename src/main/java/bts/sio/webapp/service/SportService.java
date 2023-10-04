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
    private SportProxy sportRepository;

    public Sport getSport(final int id) {
        return sportRepository.getSport(id);
    }

    public Iterable<Sport> getSports() {
        return sportRepository.getSports();
    }

    public void deleteSport(final int id) {
        sportRepository.deleteSport(id);
    }

    public Sport saveSport(Sport sport) {
        Sport savedSport;

        // Functional rule : Last name must be capitalized.
        sport.setNom(sport.getNom().toUpperCase());
        sport.setDescriptif(sport.getDescriptif().toUpperCase());

        if(sport.getId() == null) {
            // If id is null, then it is a new employee.
            savedSport = sportRepository.createSport(sport);
        } else {
            savedSport = sportRepository.updateSport(sport);
        }

        return savedSport;
    }
}