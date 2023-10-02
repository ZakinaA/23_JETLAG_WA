package bts.sio.webapp.model;

import lombok.Data;

@Data
public class Epreuve {

    private Integer id;
    private String nom;
    private String descriptif;
    private Athlete athlete;
}
