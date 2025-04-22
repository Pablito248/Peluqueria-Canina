package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
      
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String obersevaciones, String alergico, String atencionEspecial, String nombreDueño, String celDueño) {
        
        Dueño dueño = new Dueño();
        dueño.setNombre(nombreDueño);
        dueño.setCelDueño(celDueño);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEspecial);
        masco.setObservaciones(obersevaciones);
        masco.setUnDueño(dueño);
        
        
        controlPersis.guardar(dueño, masco);
        
        
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
       controlPersis.borrarMascota (num_cliente);
    }


    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String obersevaciones, String alergico, String atencionEspecial, String nombreDueño, String celDueño) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(obersevaciones);
        masco.setAtencion_especial(atencionEspecial);
        masco.setAlergico(alergico);
        
        
        controlPersis.modificarMascota(masco);
        
        Dueño dueno = this.buscarDueño(masco.getUnDueño().getId_dueño());
        dueno.setCelDueño(celDueño);
        dueno.setNombre(nombreDueño);
        
        
        this.modificarDueño(dueno);
    }

    private Dueño buscarDueño(int id_dueño) {
        return controlPersis.traerDueño(id_dueño);
    }

    private void modificarDueño(Dueño dueno) {
        controlPersis.modificarDueño(dueno);
    }
}
    
    
