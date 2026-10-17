package ir.maktabsharif.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktabsharif.dto.UserReqDto;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registration" , value = "/registration")
public class RegistrationServlet extends HttpServlet {
    ObjectMapper objectMapper =new ObjectMapper();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!req.getContentType().equalsIgnoreCase("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserReqDto userReqDto = objectMapper.readValue(req.getReader() , UserReqDto.class);


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK    );

        userService.create(userReqDto);
        objectMapper.writeValue(resp.getWriter() , "Dear    " + userReqDto.getUsername() + "    Your Account Has Been Create Successfully");


    }
}
