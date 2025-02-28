package modelo;
public class CitaModelo {
    
    private MedicoModelo doctor;
    private String fecha;
    private String hora;
    private String paciente;
    
    
    public CitaModelo(String paciente, String fecha, String hora, MedicoModelo doctor) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;
    }
    
    public CitaModelo(String fecha, String hora,  MedicoModelo doctor) {
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public MedicoModelo getDoctor() {
        return doctor;
    }

    public void setDoctor(MedicoModelo doctor) {
        this.doctor = doctor;
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

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
    
    
}
