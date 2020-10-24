package servlets;

import model.Point;
import service.CheckHitPoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private List<Point> results = new ArrayList<>();
    private double coordinateX;
    private double coordinateY;
    private double coordinateR;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            coordinateX = Double.parseDouble(request.getParameter("coordinateX"));
            coordinateY = Double.parseDouble(request.getParameter("coordinateY"));
            coordinateR = Double.parseDouble(request.getParameter("coordinateR"));
        } catch (NumberFormatException | NullPointerException e) {
            getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(request, response);
        }

        boolean hit = CheckHitPoint.checkHit(coordinateX, coordinateY, coordinateR);
        Point point = new Point(coordinateX, coordinateY, coordinateR, hit);
        results.add(point);

        getServletContext().setAttribute("results", results);
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
