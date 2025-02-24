package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModel;
import modelo.MedicoModelo;

public class MedicoControlador {
    ArrayList<MedicoModelo> listaMedico;
    
    private static MedicoControlador instancia;

    private MedicoControlador() {
    this.listaMedico = new ArrayList<>();
    }
        public static MedicoControlador getInstancia(){
               if (instancia == null){
                   instancia =new MedicoControlador();
               }
               return instancia;
        }
        public MedicoModelo AgregarMedico(EspecialidadModel em, String cedula, String nombres, int edad, boolean sexo ){
            MedicoModelo modeloMedico = new MedicoModelo(em, cedula, nombres, edad, sexo);
            listaMedico.add(modeloMedico);
            return modeloMedico;
        }
        public ArrayList<MedicoModelo> listadoCompleto(){
            return listaMedico;
        }
        
       
}
