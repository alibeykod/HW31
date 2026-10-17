package ir.maktabsharif.repository;

import ir.maktabsharif.dao.UserDAO;

import java.util.List;

public interface UserRepo {
    UserDAO create(UserDAO userDAO);
    UserDAO update(UserDAO userDAO);
    UserDAO findById(Long id);
    List<UserDAO> findAll();
    void delete(Long id);
    UserDAO findByUsername(String username);
}
