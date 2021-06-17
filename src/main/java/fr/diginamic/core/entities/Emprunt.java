package fr.diginamic.core.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Emprunt pour la mapper avec la table Emprunt en utilisant JPA-Hibernate
 * @author Miryem HRARTI
 */
/**
 * Classe Emprunt pour la mapper avec la table Emprunt en utilisant JPA-Hibernate
 * @author Miryem HRARTI
 */
@Entity
@Table(name="EMPRUNT")
public class Emprunt {
    /**
     * id: clé primaire -- identifiant
     * dateDebut: date de début d'emprunt
     * dateFin: date de fin d'emprunt
     * delai: nombre de jours d'emprunt
     * client: qui a emprunté le livre
     */
    @Id
    @Column(name="ID", nullable = false)
    private long id;
    @Column(name="DATE_DEBUT", nullable = false)
    private LocalDate dateDebut;
    @Column(name="DATE_FIN", nullable = true)
    private LocalDate dateFin;
    @Column(name="DELAI", nullable = true)
    private long delai;
    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID")
    )
    private Set<Livre> livres;

    /**
     * Constructeur
     */
    public Emprunt() {
        livres = new HashSet<>();
    }

    /**
     *
     * @return l'identifiant d'emprunt
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'id de l'emprunt
     * @param id nouveau id de l'emprunt
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return la date de début de l'emprunt
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * modifie la date de début de de l'emprunt
     * @param dateDebut nouvelle date de début
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     *
     * @return la date de fin de l'emprunt
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * modifie la date de fin de l'emprunt
     * @param dateFin nouvelle date de fin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     *
     * @return le délai de l'emprunt
     */
    public long getDelai() {
        return delai;
    }

    /**
     * modifie le délai de l'emprunt
     * @param delai nouveau délai de l'emprunt
     */
    public void setDelai(long delai) {
        this.delai = delai;
    }

    /**
     *
     * @return le client qui a fait  l'emprunt
     */
    public Client getClient() {
        return client;
    }

    /**
     * modifie le client qui a fait  l'emprunt
     * @param client nouveau client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * liste des livres de l'emprunt
     * @return
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    /**
     * modifie la liste des livres
     * @param livres nouvelle liste
     */
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "id:" + id +
                ", dateDebut:" + dateDebut +
                ", dateFin:" + dateFin +
                ", delai:" + delai +
                ", Client: " + client.getPrenom() +" "+ client.getNom().toUpperCase()+ "}";
    }
}

