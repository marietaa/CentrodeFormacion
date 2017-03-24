
package controladoresServlet;

import dao.alumno.centroformacion.DaoAlumno;
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


public class ServletMostrarAlumno extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
       ResultSet lista_alumnos = DaoAlumno.mostrarAlumno();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Alumnos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Alumnos</h1>");
            while (lista_alumnos.next()) {
                out.println("<p>" + lista_alumnos.getString("idAlumno") + "</p>");
                out.println("<p>" + lista_alumnos.getString("nombre") + " " + lista_alumnos.getString("apellido") + "</p>");
                out.println("<p>" + lista_alumnos.getString("curso") + "</p>");
                out.println("<p>---------------------------------------------------------------</p>");
                //out.println("<br/>");
            }
            out.println("<a href='index.htm'>"+"Volver al inicio"+"</a>");
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
            Logger.getLogger(ServletMostrarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletMostrarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletMostrarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
