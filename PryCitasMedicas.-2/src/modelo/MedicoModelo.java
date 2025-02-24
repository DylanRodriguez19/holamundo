package modelo;
public class MedicoModelo extends PacienteModelo{
    public EspecialidadModel especialidad;
    public MedicoModelo(EspecialidadModel especialidad, String cedula, String nombres, int edad, boolean sexo) {
        super(cedula, nombres, edad, sexo);

    }

    public EspecialidadModel getEspecilidad() {
        return especialidad;
    }

    public void setEspecilidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    }
    
   
    
    
}
