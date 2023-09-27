/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo80;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidadgrupo80.accesoADatos.AlumnoData;
import universidadgrupo80.accesoADatos.Conexion;
import universidadgrupo80.accesoADatos.InscripcionData;
import universidadgrupo80.accesoADatos.MateriaData;
import universidadgrupo80.entidades.Alumno;
import universidadgrupo80.entidades.Inscripcion;

/**
 *
 * @author Moksys
 */
public class UniversidadGrupo80 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con = Conexion.getConnection();
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id= new InscripcionData();
        
//------------------------------------------------------------------------------------------
        //Alumno juancito = new Alumno(23454323, "Martinez", "Pedro", LocalDate.of(1992, 01, 07), true);
        //ad.guardarAlumno(juancito);
        //ad.modificarAlumno(juancito);
        //ad.BuscarAlumno(1);
        //ad.eliminarAlumno(1);
        
//------------------------------------------------------------------------------------------        
        
//        Alumno alumnoEncontrado = alu.BuscarAlumnoPorDni(43856345);
//        System.out.println(alumnoEncontrado);

//------------------------------------------------------------------------------------------

//        for (Alumno alumno: alu.listarAlumnos()) {
//            System.out.println("DNI: "+alumno.getDni());
//            System.out.println("Apellido: "+alumno.getApellido());
//            System.out.println("Nombre: "+alumno.getNombre());
//            System.out.println("Fecha de Nacimiento: "+alumno.getFechaNac());
//            System.out.println("");

//------------------------------------------------------------------------------------------

        
       /*
        Alumno valentina = ad.BuscarAlumno(2);
        Materia mate = md.BuscarMateria(1);
        Inscripcion insc= new Inscripcion(valentina, mate, 3);
        
        id.guardarInscripcion(insc); */

//------------------------------------------------------------------------------------------

//        id.actulizarNota(1, 1, 4);

//------------------------------------------------------------------------------------------

//          id.borrarInscripcionMateriaAlumno(1, 1);

//------------------------------------------------------------------------------------------

        for (Inscripcion insc : id.obtenerInscripciones()) {
            
           System.out.println("id: "+ insc.getIdInscripcion());
           System.out.println("apellido: "+ insc.getAlumno().getApellido());
           System.out.println("nombre: "+ insc.getAlumno().getNombre());
           System.out.println("materia: "+insc.getMateria().getNombre());
            System.out.println("------------");
        }

//------------------------------------------------------------------------------------------

//        for (Materia materia : id.obtenerMateriasCursadas(1)) {
//            
//            System.out.println("nombre: "+ materia.getNombre());
//            
//        }


    }
}