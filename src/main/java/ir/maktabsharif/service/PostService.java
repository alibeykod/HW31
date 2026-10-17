package ir.maktabsharif.service;

import ir.maktabsharif.dto.PostReqDto;
import ir.maktabsharif.dto.PostRespDto;

import java.util.List;

public interface PostService {
    PostRespDto create(PostReqDto postReqDto);
    PostRespDto update(PostReqDto postReqDto);
    PostRespDto findByID(Long id);
    List<PostRespDto> findAll();
    void delete(Long id);
    public List<PostRespDto> getUserPostsById(Long id);
}
