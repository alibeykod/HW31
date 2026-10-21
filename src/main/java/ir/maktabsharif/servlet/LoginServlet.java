package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.UserReqDto;
import ir.maktabsharif.dto.UserRespDto;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login" ,value = "/login")
public class LoginServlet extends HttpServlet {
ObjectMapper objectMapper = new ObjectMapper();
UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().equalsIgnoreCase("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserReqDto userReqDto = objectMapper.readValue(req.getReader() , UserReqDto.class);

        boolean isAuthenticate = userService.authenticate(userReqDto);

        if (isAuthenticate){
            HttpSession session = req.getSession();
            UserRespDto userResp = userService.findByUsername(userReqDto);
            session.setAttribute("id", userResp.getId());
            session.setAttribute("username" , userResp.getUsername());
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(HttpServletResponse.SC_OK);

            objectMapper.writeValue(resp.getWriter(), "Dear " + userResp.getUsername() + " Welcome");
        }

    }
}
