
package dao.alumno.centroformacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Conexion;


public class DaoAlumno {
   
    public static void insertarAlumno(String idAlumno, String nombre, String apellido, String curso) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into centroformacion (idAlumno,nombre,apellido,curso) values ";
        consultaSQL += "('" + idAlumno + "','" + nombre + "','" + apellido + "','" + curso + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        Conexion.cerrarConexion();

    }

    public static ResultSet mostrarAlumno() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idAlumno,nombre,apellido,curso from centroformacion";
        ResultSet lista_alumnos = sentencia.executeQuery(consultaSQL);
        return lista_alumnos;

    }

    public static void actualizarAlumno(String idAlumno, String nombre, String apellido, String curso) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String consultaSQL = "update centroformacion set nombre=?, apellido=?, curso=? where idAlumno=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        //los numeros son la posicion de la consulta SQL
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setString(3, curso);
        actualizar.setString(4, idAlumno);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = actualizar.executeUpdate(consultaSQL);
        System.out.println("Filas afectadas: " + filasAfectadas);

    }
    
    public static void borrarAlumno (String idAlumno, String nombre, String apellido, String curso){
    
        //PENDIENTE DE HACER
    
    }

}
    

