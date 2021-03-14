package emergon;

import emergon.stateful.ShoppingCartLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShoppingCartClient", urlPatterns = {"/ShoppingCartClient"})
public class ShoppingCartClient extends HttpServlet {

    @EJB
    ShoppingCartLocal shoppingCart;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCartClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Starting Shopping Cart test ... </h1>");
            out.println("<h1>ShoppingCart Lookup </h1>");
            out.println("<h1>Adding Wine Item </h1>");
            shoppingCart.addWine("Zinfandel");
            out.println("<h1>Printing Cart Items </h1>");
            List<String> cartItems = shoppingCart.getWines();
            for (String wine : (List<String>) cartItems) {
                out.println("<h1>" + wine + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
