package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.PostReqDto;
import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.dto.UserRespDto;
import ir.maktabsharif.service.PostService;
import ir.maktabsharif.service.PostServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "profile" , value = "/profile")
public class ProfileServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();
    PostService postService = new PostServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().equalsIgnoreCase("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        PostReqDto postReqDto = objectMapper.readValue(req.getReader() , PostReqDto.class);

        postService.create(postReqDto);

        HttpSession session = req.getSession(false);

       Long id = (Long) session.getAttribute("userId");

      List<PostRespDto> posts = postService.getUserPostsById(id);

      objectMapper.writeValue(resp.getWriter() ,  posts);

    }
}

