
package controlador;

import java.util.ArrayList;
import modelo.MedicoModelo;


public class EspecialidadDoctorControlador {
   private ArrayList<MedicoModelo> listaMedicos = new ArrayList<>();

    public EspecialidadDoctorControlador() {
        listaMedicos.add(new MedicoModelo("Dr. Pérez", "Cardiología"));
        listaMedicos.add(new MedicoModelo("Dr. Gómez", "Pediatría"));
        listaMedicos.add(new MedicoModelo("Dr. Martínez", "Dermatología"));
        listaMedicos.add(new MedicoModelo("Dr. López", "Cardiología"));
        listaMedicos.add(new MedicoModelo("Dra. Rodríguez", "Neurología"));
    }

    public void agregarMedico(String nombre, String especialidad) {
        listaMedicos.add(new MedicoModelo(nombre, especialidad));
    }

    public ArrayList<MedicoModelo> obtenerMedicos() {
        return listaMedicos;
    }

    public ArrayList<MedicoModelo> listadoCompletoPorEspecialidad(String especialidad) {
        ArrayList<MedicoModelo> nuevaListaMedicos = new ArrayList<>();
        for (MedicoModelo medico : listaMedicos) {
            if (medico.getEspecialidad().contains(especialidad)) {
                nuevaListaMedicos.add(medico);
            }
        }
        return nuevaListaMedicos;
    }
}
