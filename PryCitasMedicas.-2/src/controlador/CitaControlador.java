
package controlador;

import java.util.ArrayList;
import modelo.CitaModelo;
import modelo.MedicoModelo;

public class CitaControlador {
     private ArrayList<CitaModelo> Listacitas = new ArrayList<>();

    public CitaControlador() {

        MedicoModelo doctor1 = new MedicoModelo("Dr. Pérez");
        MedicoModelo doctor2 = new MedicoModelo("Dr. Gómez");
        MedicoModelo doctor3 = new MedicoModelo("Dr. Martínez");
        MedicoModelo doctor4 = new MedicoModelo("Dr. López");
        MedicoModelo doctor5 = new MedicoModelo("Dra. Rodríguez");
        
        Listacitas.add(new CitaModelo("2025-10-25", "10:00",  doctor1));
        Listacitas.add(new CitaModelo("2025-10-25", "14:00", doctor2));
        Listacitas.add(new CitaModelo("2025-10-26", "09:00", doctor3));
        Listacitas.add(new CitaModelo("2025-10-26", "11:00",  doctor4));
        Listacitas.add(new CitaModelo("2025-10-27", "16:00",  doctor5));
    }

    public CitaModelo agendarCita(String fecha, String hora, String paciente, MedicoModelo doctor) {
        CitaModelo cita = new CitaModelo(fecha, hora, doctor);
        Listacitas.add(cita);
        return cita;
    }

    public ArrayList<CitaModelo> obtenerCitas() {
        return Listacitas;
    }

    public ArrayList<CitaModelo> buscarCitasPorFecha(String fecha) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : Listacitas) {
            if (cita.getFecha().equals(fecha)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    public ArrayList<CitaModelo> buscarCitasPorHora(String hora) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : Listacitas) {
            if (cita.getHora().equals(hora)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }

    public ArrayList<CitaModelo> buscarCitasPorFechaYHora(String fecha, String hora) {
        ArrayList<CitaModelo> citasFiltradas = new ArrayList<>();
        for (CitaModelo cita : Listacitas) {
            if (cita.getFecha().equals(fecha) && cita.getHora().equals(hora)) {
                citasFiltradas.add(cita);
            }
        }
        return citasFiltradas;
    }
}


