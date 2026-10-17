package ir.maktabsharif.service;

import ir.maktabsharif.dto.UserReqDto;
import ir.maktabsharif.dto.UserRespDto;

import java.util.List;

public interface UserService {
    UserRespDto create(UserReqDto userReqDto);
    UserRespDto update(UserReqDto userReqDto);
    UserRespDto findById(Long id);
    List<UserRespDto> findAll();
    void delete(Long id);
    boolean authenticate(UserReqDto userReqDto);
    UserRespDto findByUsername(UserReqDto userReqDto);
}
