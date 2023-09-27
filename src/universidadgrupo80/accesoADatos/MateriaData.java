/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo80.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo80.entidades.Materia;

/**
 *
 * @author Moksys
 */
public class MateriaData {
    
    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConnection();
        
    }
    
    public void guardarMateria(Materia materia) throws SQLException{
        String sql = "INSERT INTO materia (nombre, año, estado)"
                + " VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha añadido la materia correctamente.");
            }
            ps.close();
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia.");
        }
    }
    
    public Materia BuscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT idMateria, nombre, año FROM materia WHERE idMateria=? AND estado =1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe esta Materia.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia.");
        }
        return materia;
    }
    
    public List <Materia> listarMaterias() {
        Materia materia = null;
        String sql = "SELECT idMateria, nombre, año FROM materia WHERE estado =1";
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));;
                materia.setEstado(true);
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia.");
        }
        return materias;
    }
    
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia.");
        }
    }
}