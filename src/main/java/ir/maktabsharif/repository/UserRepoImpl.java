package ir.maktabsharif.repository;

import ir.maktabsharif.dao.UserDAO;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class UserRepoImpl implements UserRepo{

    @Override
    public UserDAO create(UserDAO userDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(userDAO);
            return userDAO;
        });
    }

    @Override
    public UserDAO update(UserDAO userDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.merge(userDAO);
            return userDAO;
        });
    }

    @Override
    public UserDAO findById(Long id) {
        return HibernateUtil.read(entityManager -> {
           UserDAO found = entityManager.find(UserDAO.class , id);
            return found;
        });
    }

    @Override
    public List<UserDAO> findAll() {
        return HibernateUtil.read(entityManager -> {
            List<UserDAO> users = entityManager.createQuery("select u from UserDAO u" , UserDAO.class).getResultList();
            return users;
        });
    }

    @Override
    public void delete(Long id) {
        HibernateUtil.read(entityManager -> {
            UserDAO foundToRemove = entityManager.find(UserDAO.class , id);
            entityManager.remove(foundToRemove);
            return id;
        });
    }

    @Override
    public UserDAO findByUsername(String username) {
       return HibernateUtil.read(entityManager -> {
           return entityManager.createQuery("select u from UserDAO u where u.username = :username" , UserDAO.class)
                   .setParameter("username", username)
                   .getSingleResult();
       });
    }

}
