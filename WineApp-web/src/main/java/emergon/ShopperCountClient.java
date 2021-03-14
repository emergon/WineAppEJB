package emergon;

import emergon.singleton.ShopperCountBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShopperCountClient", urlPatterns = {"/ShopperCountClient"})
public class ShopperCountClient extends HttpServlet {

    @EJB
    ShopperCountBean shopperCount;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopperCountClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resetting Shopper Count ... </h1>");
            shopperCount.resetCounter();
            out.println("<h1>Incrementing Shopper Count ... </h1>");
            shopperCount.incrementNumberOfShoppers();
            out.println("<h1>Shopper Count: " + shopperCount.getNumberOfShoppers() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
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
