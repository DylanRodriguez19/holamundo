
package modelo;


public class CitaModelo {
  public PacienteModelo paciente;
  public EspecialidadModelo especialidad;
  public MedicoModelo medico;
 String asunto,fecha,hora;   

    public CitaModelo(PacienteModelo paciente, EspecialidadModelo especialidad, MedicoModelo medico,String asunto , String fecha, String hora) {
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.medico = medico;
        this.asunto = asunto;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public PacienteModelo getPaciente() {
        return paciente;
    }

    public EspecialidadModelo getEspecialidad() {
        return especialidad;
    }

    public MedicoModelo getMedico() {
        return medico;
    }

    
    
}
