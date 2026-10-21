package ir.maktabsharif.servlet;

import ir.maktabsharif.dto.PostRespDto;
import ir.maktabsharif.service.PostService;
import ir.maktabsharif.service.PostServiceImpl;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    private final static PostService postService = new PostServiceImpl();
    private final static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (!req.getContentType().equalsIgnoreCase("application/json")){
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST );
        return;
    }
        HttpSession session = req.getSession(false);

        Long id = Long.parseLong(req.getParameter("id"));

        List<PostRespDto> postsById =  postService.getUserPostsById(id);

        ob


    }
}
