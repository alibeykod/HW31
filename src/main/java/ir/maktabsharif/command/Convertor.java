package ir.maktabsharif.command;

import ir.maktabsharif.dao.PostDAO;
import ir.maktabsharif.dao.UserDAO;
import ir.maktabsharif.dto.PostReqDto;
import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.dto.UserReqDto;
import ir.maktabsharif.dto.UserRespDto;

public class Convertor {
    public static UserDAO userReqDtoToUserDao(UserReqDto userReqDto) {
        return UserDAO.builder()
                .username(userReqDto.getUsername())
                .fullName(userReqDto.getFullName())
                .password(userReqDto.getPassword())
                .build();
    }

    public static UserRespDto userDaoToUserRespDto(UserDAO userDAO){
        return new UserRespDto(userDAO.getId() , userDAO.getFullName(), userDAO.getUsername());
    }

    public static PostDAO postReqDtoToPostDao(PostReqDto postReqDto){
        return PostDAO.builder()
                .title(postReqDto.getTitle())
                .TextOfPost(postReqDto.getTextOfPost())
                .build();
    }

    public static PostRespDto postDaoToPostRespDto(PostDAO postDAO){
        return new PostRespDto(
                postDAO.getId(),
                postDAO.getTitle(),
                postDAO.getTextOfPost()
        );
    }
}
