package ir.maktabsharif.repository;

import ir.maktabsharif.dao.PostDAO;

import java.util.List;

public interface PostRepo {
    PostDAO create(PostDAO postDAO);
    PostDAO update(PostDAO postDAO);
    PostDAO findById(long id);
    List<PostDAO> findAll();
    void delete(Long id);
    List<PostDAO> getUserPostsById(Long id);

}
