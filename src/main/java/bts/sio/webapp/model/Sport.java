package bts.sio.webapp.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Sport {

    private Integer id;
    private String nom;
    private String descriptif;
    private Athlete athlete;


}