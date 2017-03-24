package controladoresServlet;

import dao.profesor.centroformacion.DaoProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMostrarProfesor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        ResultSet lista_profesores = DaoProfesor.mostrarProfesor();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Profesores</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Profesores</h1>");
            while (lista_profesores.next()) {
                out.println("<p>" + lista_profesores.getString("idProfesor") + "</p>");
                out.println("<p>" + lista_profesores.getString("nombre") + " " + lista_profesores.getString("apellido") + "</p>");
                out.println("<p>" + lista_profesores.getString("especialidad") + "</p>");
                out.println("<p>---------------------------------------------------------------</p>");
                //out.println("<br/>");
            }
            out.println("<a href='index.htm'>" + "Volver al inicio" + "</a>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
