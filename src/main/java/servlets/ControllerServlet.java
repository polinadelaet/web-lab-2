package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String coordinateX = request.getParameter("coordinateX");
        String coordinateY = request.getParameter("coordinateY");
        String coordinateR = request.getParameter("coordinateR");
        //boolean result = checkFormProcess(coordinateX, coordinateY, coordinateR);



            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);

        //    getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

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
        boolean kek = setX.contains(x) && (y > -4) && (y < 6) && (setR.contains(r));
        return setX.contains(x) && (y > -4) && (y < 6) && (setR.contains(r));
    }
}
