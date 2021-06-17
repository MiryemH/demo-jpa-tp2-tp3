package fr.diginamic.core.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Client pour la mapper avec la table Client en utilisant JPA-Hibernate
 * @author Miryem HRARTI
 */
@Entity
@Table(name="CLIENT")
public class Client {
    /**
     * id: identifiant du client, clé primaire
     * nom: du client
     * prénom du client
     * mesEmprunts: liste des emprunts du client
     */
    @Id
    @Column(name="ID", nullable = false)
    private Long id;
    @Column(name="NOM", nullable = false)
    private String nom;
    @Column(name="PRENOM", nullable = false)
    private String prenom;
    @OneToMany(mappedBy="client")
    private Set<Emprunt> mesEmprunts; // référence vers les chambres
    /**
     * Constructeur par défaut Obligatoire
     */
    public Client() {
        mesEmprunts = new HashSet<>();
    }

    /**
     * Constructeur
     * @param nom du client
     * @param prenom du client
     */
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     *
     * @return l'id du client
     */
    public Long getId() {
        return id;
    }

    /**
     * modifie l'id client
     * @param id nouveau id du client
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return le nom client
     */
    public String getNom() {
        return nom;
    }

    /**
     * modifie le nom du client
     * @param nom nouveau nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return le prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * modifie le prénom du client
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return la liste des emprunts d'un client
     */
    public Set<Emprunt> getMesEmprunts() {
        return mesEmprunts;
    }

    /**
     * modifie la liste des emprunts d'un client
     * @param mesEmprunts nouvelle liste
     */
    public void setMesEmprunts(Set<Emprunt> mesEmprunts) {
        this.mesEmprunts = mesEmprunts;
    }
    /**
     *
     * @return une chaine de caractères qui décrit le client en concaténant: id, nom et prénom
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "id:" + id +
                ", nom:" + nom +
                ", prenom=" + prenom +"}";
    }
}
