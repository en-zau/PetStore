package org.PetStore;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.PetStore.entities.*;
import org.PetStore.entities.enumere.FishLivEnv;
import org.PetStore.entities.enumere.ProdType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product product1 = new Product("3333", "panié", ProdType.ACCESSORY, 30.00);
        Product product2 = new Product("0005", "crevette", ProdType.FOOD, 9.00);
        Product product3 = new Product("9999", "cleanup", ProdType.CLEANING, 18.00);

        Address address1 = new Address("04", "rue du platane", "12337", "Montreal");
        Address address2 = new Address("11", "rue des bateaux", "02373", "Nantes");
        Address address3 = new Address("23", "rue des frênes", "03740", "Corcoué");
        PetStore petStore1 = new PetStore("Le Bon Giguo", "Elon Musk", address1);
        petStore1.addProduct(product1);
        petStore1.addProduct(product2);
        petStore1.addProduct(product3);

        PetStore petStore2 = new PetStore("L'entrecote", "Mark Zuckenberg", address2);
        petStore2.addProduct(product1);
        petStore2.addProduct(product2);
        petStore2.addProduct(product3);

        PetStore petStore3 = new PetStore("Charal", "Emmanuel Macron", address3);
        petStore3.addProduct(product1);
        petStore3.addProduct(product2);
        petStore3.addProduct(product3);

        Animal animal1 = new Animal(LocalDate.now(), "beige/blanc", petStore1);
        Cat cat1 = new Cat(LocalDate.now(), "beige/blanc", petStore1, "ohoh");
        Fish fish1 = new Fish(LocalDate.now(), "beige/blanc", petStore1, FishLivEnv.SEA_WATER);

        Animal animal2 = new Animal(LocalDate.now(), "noir", petStore2);
        Cat cat2 = new Cat(LocalDate.now(), "noir", petStore2, "bravo");
        Fish fish2 = new Fish(LocalDate.now(), "noir", petStore2, FishLivEnv.FRESH_WATER);

        Animal animal3 = new Animal(LocalDate.now(), "vannile/choco", petStore3);
        Cat cat3 = new Cat(LocalDate.now(), "vannile/choco", petStore3, "felicitation");
        Fish fish3 = new Fish(LocalDate.now(), "vannile/choco", petStore3, FishLivEnv.FRESH_WATER);


        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        em.persist(animal1);
        em.persist(cat1);
        em.persist(fish1);
        em.persist(animal2);
        em.persist(cat2);
        em.persist(fish2);
        em.persist(animal3);
        em.persist(cat3);
        em.persist(fish3);


        em.getTransaction().commit();

        Query q = em.createQuery("select id, birth, color from Animal where petStore.id = 1");
        List resultList = q.getResultList();
        System.out.println("num of animals:" + resultList.size());
        for (Object next : resultList) {
            System.out.println("next animal: " + next);
        }

        em.close();
        emf.close();
    }
}
