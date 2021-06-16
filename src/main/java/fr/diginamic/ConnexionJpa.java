package fr.diginamic;

import fr.diginamic.core.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maConfig");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Livre livreCherche = manager.find(Livre.class, 4L);
        System.out.println("Livre cherché: "+livreCherche);
        //Livre nvLivre = new Livre(6, "Guy maupassant", "Une vie");
        //manager.persist(nvLivre);
        livreCherche = manager.find(Livre.class, 6L);
        System.out.println("Livre inséré: "+livreCherche);
        livreCherche.setAuteur("Guy Maupassant");
        livreCherche = manager.find(Livre.class, 6L);
        System.out.println("Livre modifié: "+livreCherche);
        manager.remove(livreCherche);
        System.out.println("Supprimé");

        transaction.commit();
        manager.close();

    }
}
