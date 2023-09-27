/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo80.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo80.entidades.Alumno;
import universidadgrupo80.entidades.Inscripcion;
import universidadgrupo80.entidades.Materia;

/**
 *
 * @author Usuario
 */
public class InscripcionData {

    private Connection con = null;
    private AlumnoData aluData = new AlumnoData();
    private MateriaData matData = new MateriaData();

    public InscripcionData() {
        this.con = Conexion.getConnection();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion(idAlumno, idMateria, nota)"
                + "VALUES (? , ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeQuery();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripto con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
    }

    public void actulizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actulizada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accerder a la tabla Inscripcion");

        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();

            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Inscripcion anulada");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

    }

    public List<Inscripcion> obtenerInscripciones() {

        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = aluData.BuscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.BuscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return cursadas;

    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {

        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = aluData.BuscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.BuscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return cursadas;

    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = " SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                + " materia WHERE inscripcion.idMateria = materia.idMateria "
                + " AND inscripcion.idAlumno = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return materias;

    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return materias;

    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {

        ArrayList<Alumno> alumnosMateria = new ArrayList<>();

        String sql = "SELECT a.idAlumno, dni, apellido, nombre, fechaNac, estado "
                + "FROM inscripcion i,alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return alumnosMateria;

    }
    
    
}
