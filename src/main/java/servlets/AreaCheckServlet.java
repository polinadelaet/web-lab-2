package servlets;

import model.Data;
import service.CheckHitPoint;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private List<Data> results = new ArrayList<Data>();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final double x = Double.parseDouble(request.getParameter("coordinateX"));
        final double y = Double.parseDouble(request.getParameter("coordinateY"));
        final double r = Double.parseDouble(request.getParameter("coordinateR"));

        final boolean hit = CheckHitPoint.checkHit(x, y, r);

        Data data = new Data(x, y, r, hit);
        results.add(data);

        getServletContext().setAttribute("results", results);

        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
