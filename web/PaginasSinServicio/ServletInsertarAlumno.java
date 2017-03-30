package controladoresServlet;

import bo.alumno.centroformacion.BoAlumno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInsertarAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        BoAlumno.procesarInsertarAlumno(request, response);
        //BoAlumno.procesarActualizarAlumno(request, response);
    }

        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInsertarAlumno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInsertarAlumno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
    


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletInsertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletInsertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletInsertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletInsertarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }

}

