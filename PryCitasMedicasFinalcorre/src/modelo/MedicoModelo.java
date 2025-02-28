
package modelo;


public class MedicoModelo extends PacienteModelo {
public EspecialidadModelo especialidad;

    public MedicoModelo(EspecialidadModelo especialidad, String cedula, String nombres, int edad, boolean sexo) {
        super(cedula, nombres, edad, sexo);
        this.especialidad = especialidad;
    }

    public EspecialidadModelo getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModelo especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "MedicoModelo{" + "especialidad=" + especialidad + '}';
    }



}
