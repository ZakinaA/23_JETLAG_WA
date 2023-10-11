package bts.sio.webapp.model;

import lombok.Data;

@Data
public class Sport {

    private Integer id;
    private String nom;
    private String descriptif;
    private String nom_image;
    private Olympiade olympiade;
    private Athlete athlete;
}