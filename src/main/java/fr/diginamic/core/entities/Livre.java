package fr.diginamic.core.entities;

import javax.persistence.*;

/**
 * Classe Livre pour la mapper avec la table Livre en utilisant JPA-Hibernate
 * @author Miryem HRARTI
 */
@Entity
@Table(name="LIVRE")
public class Livre {
    /**
     * id: identifiant du livre, clé primaire
     * auteur: qui l' écrit
     * titre du livre
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="AUTEUR", nullable = false)
    private String auteur;
    @Column(name="TITRE", nullable = false)
    private String titre;

    /**
     * Constructeur par défaut obligatoire pour JPA
     */
    public Livre(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * description du live
     * @return une chaine de caractères
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+"{ id: " + id +", auteur: " + auteur  + ", titre: " + titre +"}";

    }
}
