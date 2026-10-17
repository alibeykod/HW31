package ir.maktabsharif.service;

import ir.maktabsharif.command.Convertor;
import ir.maktabsharif.dao.UserDAO;
import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.dto.UserReqDto;
import ir.maktabsharif.dto.UserRespDto;
import ir.maktabsharif.repository.UserRepoImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepoImpl userRepo = new UserRepoImpl();


    @Override
    public UserRespDto create(UserReqDto userReqDto) {
        UserDAO userDAO = userRepo.create(Convertor.userReqDtoToUserDao(userReqDto));
        return Convertor.userDaoToUserRespDto(userDAO);
    }

    @Override
    public UserRespDto update(UserReqDto userReqDto) {
        UserDAO userDAO = userRepo.update(Convertor.userReqDtoToUserDao(userReqDto));
        return Convertor.userDaoToUserRespDto(userDAO);
    }

    @Override
    public UserRespDto findById(Long id) {
        return Convertor.userDaoToUserRespDto(userRepo.findById(id));
    }

    @Override
    public List<UserRespDto> findAll() {
        return userRepo.findAll().stream().map(Convertor::userDaoToUserRespDto).toList();
    }

    @Override
    public void delete(Long id) {
        userRepo.delete(id);
    }

    @Override
    public UserRespDto findByUsername(UserReqDto userReqDto) {
        return Convertor.userDaoToUserRespDto(userRepo.findByUsername(userReqDto.getUsername()));
    }

    public boolean authenticate(UserReqDto userReqDto) {
        UserDAO userDAO = userRepo.findByUsername(userReqDto.getUsername());
        return userDAO.getPassword().equals(userReqDto.getPassword());
    }


}
