package com.avvsoft2050.controller;

import com.avvsoft2050.dao.DeveloperDao;
import com.avvsoft2050.model.Developer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeveloperController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/developer.jsp";
    private static final String LIST_DEVELOPER = "/listDeveloper.jsp";
    private final DeveloperDao dao;

    public DeveloperController() {
        super();
        dao = new DeveloperDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int developerId = Integer.parseInt(request.getParameter("developerId"));
            dao.deleteDeveloper(developerId);
            forward = LIST_DEVELOPER;
            request.setAttribute("developers", dao.getAllDevelopers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int developerId = Integer.parseInt(request.getParameter("developerId"));
            Developer developer = dao.getDeveloperById(developerId);
            request.setAttribute("developer", developer);
        } else if (action.equalsIgnoreCase("listDeveloper")) {
            forward = LIST_DEVELOPER;
            request.setAttribute("developers", dao.getAllDevelopers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Developer developer = new Developer();
        developer.setName(request.getParameter("name"));
        developer.setSpecialty(request.getParameter("specialty"));
        developer.setSalary(Integer.parseInt(request.getParameter("salary")));
        String developerId = request.getParameter("developerId");
        if (developerId == null || developerId.isEmpty()) {
            dao.addDeveloper(developer);
        } else {
            developer.setDeveloperId(Integer.parseInt(developerId));
            dao.updateDeveloper(developer);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_DEVELOPER);
        request.setAttribute("developers", dao.getAllDevelopers());
        view.forward(request, response);
    }
}