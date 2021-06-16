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
    @Column(name="ID", nullable = false)
    private Long id;
    @Column(name="AUTEUR", nullable = false)
    private String auteur;
    @Column(name="TITRE", nullable = false)
    private String titre;

    /**
     * Constructeur par défaut obligatoire pour JPA
     */
    public Livre(){
    }

    /**
     * construit un livre avec son auteur et son titre
     * @param id du livre
     * @param auteur du livre
     * @param titre du livre
     */
    public Livre(long id, String auteur, String titre) {
        this.id = id;
        this.auteur = auteur;
        this.titre = titre;
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
