package bts.sio.webapp.model;

import lombok.Data;

@Data
public class Epreuve {

    private Integer id;
    private String libelle;
    private String date_debut;
    private String date_fin;
    private Sport sport;
}
