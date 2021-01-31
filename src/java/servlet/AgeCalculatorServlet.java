
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
   }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int agei = 0;
        String age = request.getParameter("age");
        String message = "";
        request.setAttribute("age", age);
        if(age != null)
            try {
                agei = Integer.parseInt(age);
                agei++;
                message = "Your age next birthday will be " + String.valueOf(agei);
            } catch (Exception e) {
                message = "You must enter a number";
            }
        else
            message = "You must give your current age";
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }


}
