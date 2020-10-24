package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/ErrorHandlerServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
    }

    private boolean checkFormProcess(String coordinateX, String coordinateY, String coordinateR) {
        List<Integer> setX = new ArrayList<Integer>(){{
            for (int i = -3; i < 6; i++)
                add(i);
        }};

        List<Integer> setR = new ArrayList<Integer>(){{
            for (int i = 1; i < 6; i++)
                add(i);
        }};
        int x;
        int y;
        int r;
        try {
            x = Integer.parseInt(coordinateX);
            y = Integer.parseInt(coordinateY);
            r = Integer.parseInt(coordinateR);
        } catch (NumberFormatException e) {
            return false;
        }
        return setX.contains(x) && (y > -4) && (y < 6) && (setR.contains(r));
    }
}
