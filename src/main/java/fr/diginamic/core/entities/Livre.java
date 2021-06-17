package fr.diginamic.core.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
     * liste des emprunts du livre
     */
    @Id
    @Column(name="ID", nullable = false)
    private long id;
    @Column(name="AUTEUR", nullable = false)
    private String auteur;
    @Column(name="TITRE", nullable = false)
    private String titre;
    @ManyToMany
    @JoinTable(name="COMPO",
                joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID")
    )
    private Set<Emprunt> emprunts;

    /**
     * Constructeur par défaut obligatoire pour JPA
     */
    public Livre(){
        emprunts = new HashSet<>();
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

    /**
     *
     * @return l'identifiant du livre
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'id du livre
     * @param id nouveau id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return l'auteur du livre
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * modifie le nom de l'auteur du livre
     * @param auteur nouveau nom d'auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     *
     * @return titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * modifie le titre du livre
     * @param titre nouveau titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }


    /**
     *
     * @return la liste des emprunts
     */
    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    /**
     * modifie la liste des emprunts
     * @param emprunts nouvelle liste d'emprunts
     */
    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
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
