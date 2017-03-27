package dao.alumno.centroformacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Conexion;

public class DaoAlumno {

    public static void insertarAlumno(int idAlumno, String nombre, String apellido, String curso) throws SQLException, ClassNotFoundException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into Alumno (idAlumno,nombre,apellido,curso) values ";
        consultaSQL += "('" + idAlumno + "','" + nombre + "','" + apellido + "','" + curso + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        Conexion.cerrarConexion();

    }

    public static ResultSet mostrarAlumno() throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idAlumno,nombre,apellido,curso from Alumno";
        ResultSet lista_alumnos = sentencia.executeQuery(consultaSQL);
        return lista_alumnos;
        
    }

    public static void actualizarAlumno(String nombre, String apellido, String curso, int idAlumno) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        //Statement sentencia = conexion.createStatement();
        String consultaSQL = "update Alumno set nombre=?, apellido=?, curso=? where idAlumno=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        //los numeros son la posicion de la consulta SQL
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setString(3, curso);
        actualizar.setInt(4, idAlumno);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        Conexion.cerrarConexion();
    }

    public static void borrarAlumno(int idAlumno, String nombre, String apellido, String curso) throws ClassNotFoundException, SQLException {

        Connection conexion = Conexion.abrirConexion();
        String consultaSQL = "delete from Alumno where idAlumno=?";
        PreparedStatement borrar = conexion.prepareStatement(consultaSQL);
        borrar.setInt(1, idAlumno);
        //Execute update devuelve el numero de filas afectadas
        int filasAfectadas = borrar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
    }
}
