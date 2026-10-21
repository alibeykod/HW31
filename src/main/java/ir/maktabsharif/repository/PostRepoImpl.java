package ir.maktabsharif.repository;

import ir.maktabsharif.command.Convertor;
import ir.maktabsharif.dao.PostDAO;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class PostRepoImpl implements PostRepo{
    @Override
    public PostDAO create(PostDAO postDAO ) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(postDAO);
            return postDAO;
        });
    }

    @Override
    public PostDAO update(PostDAO postDAO) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.merge(postDAO);
            return postDAO;
        });
    }

    @Override
    public PostDAO findById(long id) {
        return HibernateUtil.read(entityManager -> {
            return entityManager.find(PostDAO.class , id);
        });
    }

    @Override
    public List<PostDAO> findAll() {
        return HibernateUtil.read(entityManager -> {
            return entityManager.createQuery("SELECT p FROM PostDAO p" , PostDAO.class).getResultList();
        });
    }

    @Override
    public void delete(Long id) {
        HibernateUtil.inTxReturn(entityManager -> {
            PostDAO foundToRemove = entityManager.find(PostDAO.class , id);
            entityManager.remove(foundToRemove);
            return id;
        });
    }

    public List<PostDAO> getUserPostsById(Long id) {
        return HibernateUtil.read(entityManager ->
               entityManager.createQuery("select p from PostDAO p where p.userDAO.id = :id" , PostDAO.class)
                        .setParameter("id", id)
                        .getResultList()
        );

    }
}
