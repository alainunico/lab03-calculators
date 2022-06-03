
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String firstValue = request.getParameter("fvalue");
            String secValue = request.getParameter("svalue");

            int fvalue = Integer.parseInt(firstValue);
            int svalue = Integer.parseInt(secValue);

            request.setAttribute("firstval", fvalue);
            request.setAttribute("secval", svalue);
                            
            String compute = request.getParameter("calculate");        

            if(firstValue != null && secValue != null){

                if(compute.equals("add")){
                    request.setAttribute("message", fvalue + svalue);
                }
                else if(compute.equals("subtract")){
                    request.setAttribute("message", fvalue - svalue);
                }
                else if(compute.equals("multiply")){
                    request.setAttribute("message", fvalue * svalue);
                }
                else if(compute.equals("divide")){
                    request.setAttribute("message", (double)fvalue / svalue);
                }
                else if (compute.equals("[a-zA-Z]")){
                    request.setAttribute("message", "Invalid input. Please try again.");
                }
            }
        } catch (NumberFormatException ex){
            request.setAttribute("message", "Invalid input. Please try again.");
        }

        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
    
}
