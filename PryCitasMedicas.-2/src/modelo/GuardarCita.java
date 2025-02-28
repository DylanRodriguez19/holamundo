
package modelo;

public class GuardarCita {
    private String paciente;
    private String fecha;
    private String hora;
    private String doctor;

    public GuardarCita(String paciente, String fecha, String hora, String doctor) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDoctor() {
        return doctor;
    }
}
