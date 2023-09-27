/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo80.accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Moksys
 */
public class Conexion {

    public static final String URL = "jdbc:mariadb://localhost/";
    public static final String DB = "universidadgrupo80";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "";
    public static Connection conexion;

    private Conexion() {
    }

    public static Connection getConnection() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);

                JOptionPane.showMessageDialog(null, "¡Conexion exitosa!");

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers ");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos ");
            }
        }
        return conexion;
    }

}
