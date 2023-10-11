package bts.sio.webapp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Epreuve {

    private Integer id;
    private String libelle;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private Sport sport;

}
