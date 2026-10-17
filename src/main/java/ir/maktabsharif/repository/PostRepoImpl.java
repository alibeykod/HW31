package ir.maktabsharif.repository;

import ir.maktabsharif.dao.PostDAO;
import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class PostRepoImpl implements PostRepo{
    @Override
    public PostDAO create(PostDAO postDAO) {
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
            PostDAO found = entityManager.find(PostDAO.class , id);
            return found;
        });
    }

    @Override
    public List<PostDAO> findAll() {
        return HibernateUtil.read(entityManager -> {
          List<PostDAO> posts =  entityManager.createQuery("SELECT p FROM PostDAO p" , PostDAO.class).getResultList();
            return posts;
        });
    }

    @Override
    public void delete(Long id) {
        HibernateUtil.read(entityManager -> {
            PostDAO foundToRemove = entityManager.find(PostDAO.class , id);
            entityManager.remove(foundToRemove);
            return id;
        });
    }

    public List<PostRespDto> getUserPostsById(Long id) {
        return HibernateUtil.read(entityManager ->
                entityManager.createQuery("select p from PostDAO p where p.id = :id", PostRespDto.class)
                        .setParameter("id", id)
                        .getResultList()
        );
    }
}
