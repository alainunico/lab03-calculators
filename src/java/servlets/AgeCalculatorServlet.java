
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ageInput = request.getParameter("age");
        try{
            int age = Integer.parseInt(ageInput);
            
            age += 1;
            String message = String.format("You will turn %d years old on your next birthday!", age);
            request.setAttribute("message", message);

        }
        catch (NumberFormatException ex){ 
            request.setAttribute("message", "Invalid input. Please type in your age as a number.");

    }
        if(ageInput.equals("")){
            request.setAttribute("message", "Invalid input. You must give your current age.");
    }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
}
}
