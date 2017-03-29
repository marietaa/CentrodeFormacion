
package controladoresServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilidades.VerificarLogin;


public class LogCentroFormacion extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
       
         //Solicito los parametros de login.html
        String user = request.getParameter("login_usuario");
        String password = request.getParameter("login_password");

        //Llamada al metodo
        boolean verificarUsuario=VerificarLogin.comprobarLogin(user, password);

        if (verificarUsuario == true) {
            //Variable Log sirve para comprobar si el usuario esta logeado en otros servlets
           // boolean log = true;
            HttpSession sesion_login = request.getSession();
            //Guardo en la sesion
            sesion_login.setAttribute("login_usuario", user);
            sesion_login.setAttribute("login_password", password);
            sesion_login.setAttribute("ok", verificarUsuario);

            response.sendRedirect("index.htm");

        } else {
            response.sendRedirect("login.html"); 
        }

        
        
       /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogCentroFormacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogCentroFormacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogCentroFormacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogCentroFormacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogCentroFormacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogCentroFormacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
