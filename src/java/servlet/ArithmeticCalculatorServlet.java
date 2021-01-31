/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rcgam
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("message") == null){ //If the attribute doesn't exsist. This is done so refreshing doesn't reset the message while the numbers stay in
            request.setAttribute("message", "---");//Set message to ---
        }
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);//if i wanted to do this all with get, i would have it do a check for operations. If its null just loads the page. Else runs script  
   }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int f1,f2 = 0;
        String operation = request.getParameter("operation");//get's values from form
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String message = "invalid"; //Sets invalid error before so that if try fails it can just go
        request.setAttribute("first", first);//Sets values of form, so that boxes are still filled in when sent back
        request.setAttribute("second", second);
        if(first != null || !first.equals("") || second != null || !second.equals("")) //Goes in if strings are populated
            try {
                f1 = Integer.parseInt(first);//Parse not get
                f2 = Integer.parseInt(second);
                switch(operation){
                    case "-":
                        message = String.valueOf(f1-f2);
                        break;
                    case "+":
                        message = String.valueOf(f1+f2);
                        break;
                    case "*":
                        message = String.valueOf(f1*f2);
                        break;
                    case "%":
                        message = String.valueOf(f1%f2);
                        break;
                }
                
            } catch (Exception e) {
                
            }

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }
}