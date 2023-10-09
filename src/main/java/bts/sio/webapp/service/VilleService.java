package bts.sio.webapp.service;

import bts.sio.webapp.model.Sport;
import bts.sio.webapp.model.Ville;
import bts.sio.webapp.repository.SportProxy;
import bts.sio.webapp.repository.VilleProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class VilleService {

    @Autowired
    private VilleProxy villeProxy;

    public Ville getVille(final int id) {return villeProxy.getVille(id);
    }

    public Iterable<Ville> getVilles() {
        return villeProxy.getVilles();
    }



}