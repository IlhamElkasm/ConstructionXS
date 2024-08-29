package com.Ressources.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RessourceDto {

    private Long id;
    private String nom;
    private String typee;
    private float quantité;
    private String Nom_fournisseur;
    private String cin_fournisseur;
    private Long idTache;
}
