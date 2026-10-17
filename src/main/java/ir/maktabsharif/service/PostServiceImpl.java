package ir.maktabsharif.service;

import ir.maktabsharif.command.Convertor;
import ir.maktabsharif.dao.PostDAO;
import ir.maktabsharif.dto.PostReqDto;
import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.repository.PostRepoImpl;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostRepoImpl postRepo = new PostRepoImpl();

    @Override
    public PostRespDto create(PostReqDto postReqDto) {
        PostDAO postDAO = postRepo.create(Convertor.postReqDtoToPostDao(postReqDto));
        return Convertor.postDaoToPostRespDto(postDAO);
    }

    @Override
    public PostRespDto update(PostReqDto postReqDto) {
        PostDAO postDAO = postRepo.update(Convertor.postReqDtoToPostDao(postReqDto));
        return Convertor.postDaoToPostRespDto(postDAO);
    }

    @Override
    public PostRespDto findByID(Long id) {
        PostDAO postDAO = postRepo.findById(id);
       return Convertor.postDaoToPostRespDto(postDAO);
    }

    @Override
    public List<PostRespDto> findAll() {
        return postRepo.findAll()
                .stream()
                .map(Convertor::postDaoToPostRespDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        postRepo.delete(id);
    }
    public List<PostRespDto> getUserPostsById(Long id){
        return postRepo.getUserPostsById(id);
    }
}
