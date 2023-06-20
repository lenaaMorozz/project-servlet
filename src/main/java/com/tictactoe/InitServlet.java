package com.tictactoe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log4j2
@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession(true);
        log.info("Create session {}", currentSession.getId());

        Field field = new Field();
        log.info("Init field");
        Map<Integer, Sign> fieldData = field.getField();

        List<Sign> data = field.getFieldData();

        currentSession.setAttribute("field", field);
        currentSession.setAttribute("data", data);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        log.info("Redirect to \"index.jsp\"");
    }
}
