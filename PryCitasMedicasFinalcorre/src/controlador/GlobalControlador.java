package controlador;

import java.util.ArrayList;

public class GlobalControlador {
PacienteControlador paciente;
    EspecialidadControlador especialidad;
    MedicoControlador medico;
    CitaControlador cita;
    
    private static GlobalControlador instancia;

    ArrayList<Object> GlobalLista;
    public static GlobalControlador getInstancia() {
        if (instancia == null) {
            instancia = new GlobalControlador();
        }
        return instancia;
    }

    public GlobalControlador() {
        this.GlobalLista = new ArrayList<>();
    }

    
    
    
    public ArrayList<Object> ListaGlobal() {
        ArrayList<Object> listaCombinada = new ArrayList<>();
listaCombinada.add(paciente.listadoCompleto());
listaCombinada.add(especialidad.RetornarListarEspecialidad());
listaCombinada.add(medico.RetornarListaMedico());
listaCombinada.add(cita.ListaCompletaCita());
        return listaCombinada;
    }

}
