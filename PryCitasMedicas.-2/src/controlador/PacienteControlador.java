package controlador;

import java.util.ArrayList;
import modelo.PacienteModelo;

public class PacienteControlador  {
    public ArrayList<PacienteModelo> listaPaciente;
    
    private static PacienteControlador instancia;

    public PacienteControlador() {
    this.listaPaciente = new ArrayList<>();
    }
    
    public static PacienteControlador getInstancia(){
        if(instancia==null){
            instancia=new PacienteControlador();
        }
        return instancia;
    }
    
    public PacienteModelo AgregarPaciente(String cedula, String nombres, int edad, boolean sexo){
        PacienteModelo modeloPaciente = new PacienteModelo(cedula, nombres, edad, sexo);
        listaPaciente.add(modeloPaciente);
        return modeloPaciente;
    }
    public ArrayList<PacienteModelo> listadoCompleto(){
        return listaPaciente;
    }
    public ArrayList<PacienteModelo> ListadoCompletoPorCedula(String cedula){
        ArrayList<PacienteModelo> nuevaListaPaciente = new ArrayList<>();
        for (PacienteModelo pacienteModelo : listaPaciente) {
            if(pacienteModelo.getCedula().contains(cedula)){
                nuevaListaPaciente.add(pacienteModelo);
            }
        }
        return nuevaListaPaciente;
    }
}
