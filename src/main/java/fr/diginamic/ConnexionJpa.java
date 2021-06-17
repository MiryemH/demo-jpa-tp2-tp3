package fr.diginamic;

import fr.diginamic.core.entities.Client;
import fr.diginamic.core.entities.Emprunt;
import fr.diginamic.core.entities.Livre;

import javax.persistence.*;
import java.util.Set;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maConfig");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Livre livreCherche = manager.find(Livre.class, 4L);
        System.out.println("Livre cherché: "+livreCherche);
        Livre nvLivre = new Livre(6, "Guy maupassant", "Une vie");
        manager.persist(nvLivre);
        livreCherche = manager.find(Livre.class, 6L);
        System.out.println("Livre inséré: "+livreCherche);
        livreCherche.setAuteur("Guy Maupassant");
        livreCherche = manager.find(Livre.class, 6L);
        System.out.println("Livre modifié: "+livreCherche);
        manager.remove(livreCherche);
        System.out.println("Supprimé");

        Emprunt emprunt = manager.find(Emprunt.class, 2L);
        if(emprunt != null) {
            System.out.println(emprunt);
            Set<Livre> livresEmpruntes = emprunt.getLivres();
            if (livresEmpruntes != null) {
                System.out.println("Livres de l'emprunt N°: " + emprunt.getId());
                livresEmpruntes.forEach(livre -> System.out.println(livre));
            } else
                System.out.println("Pas de livres empruntés avec le N°Emprunt: " + emprunt.getId());
        }
        else
            System.out.println("Aucun emprunt de cet Identifiant");
        Client client = manager.find(Client.class, 3L);
        if(client != null){
            System.out.println(client);
            Set<Emprunt> empruntsClient = client.getMesEmprunts();
            if(empruntsClient != null){
                System.out.println("Emprunts effectués par le client N°: " + client.getId());
                empruntsClient.forEach(emp -> System.out.println(emp));
            }
            else
                System.out.println("Ce client n'a pas effectué d'emprunts");
        }
        else
            System.out.println("Aucun Client de cet Identifiant");

        transaction.commit();
        manager.close();

    }
}
