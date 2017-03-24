
package dao.profesor.centroformacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Conexion;


public class DaoProfesor {
   
    public static void insertarProfesor(String idProfesor, String nombre, String apellido, String especialidad) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into centroformacion (idProfesor,nombre,apellido,especialidad) values ";
        consultaSQL += "('" + idProfesor + "','" + nombre + "','" + apellido + "','" + especialidad + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        Conexion.cerrarConexion();

    }

    public static ResultSet mostrarProfesor() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idProfesor,nombre,apellido,especialidad from centroformacion";
        ResultSet lista_profesores = sentencia.executeQuery(consultaSQL);
        return lista_profesores;

    }

    public static void actualizarProfesor(String idProfesor, String nombre, String apellido, String especialidad) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String consultaSQL = "update centroformacion set nombre=?, apellido=?, especialidad=? where idProfesor=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        //los numeros son la posicion de la consulta SQL
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setString(3, especialidad);
        actualizar.setString(4, idProfesor);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = actualizar.executeUpdate(consultaSQL);
        System.out.println("Filas afectadas: " + filasAfectadas);

    }
    
    public static void borrarProfesor (String idProfesor, String nombre, String apellido, String especialidad){
    
        //PENDIENTE DE HACER
    
    }

}
        

