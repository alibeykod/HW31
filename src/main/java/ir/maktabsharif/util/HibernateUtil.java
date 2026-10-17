package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class HibernateUtil {
    private static EntityManagerFactory emf ;
    private final static String PERSISTENCE_UNIT = "postgres-pu" ;

    public static synchronized EntityManagerFactory getEmf(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager getEm(){
        return getEmf().createEntityManager();
    }

    public static  <T> T read(Function<EntityManager , T> operation){
        EntityManager em  = getEm();

        try {
            return operation.apply(em);
        }finally {
            em.close();
        }
    }


    public static <T> T inTxReturn(Function<EntityManager, T> operation)
    {
        EntityManager em = getEm();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }}
