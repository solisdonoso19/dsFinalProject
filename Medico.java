import java.util.*
import java.swing.*;

public class Medico extends Persona{
    Integer codigo, especialidad, pacientes_mes, pacientes_anual;

    
    public Medico(Integer codigo, Integer especialidad) {
        this.codigo = codigo;
        this.especialidad = especialidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Integer especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getPacientes_mes() {
        return pacientes_mes;
    }

    public void setPacientes_mes(Integer pacientes_mes) {
        this.pacientes_mes = pacientes_mes;
    }

    public Integer getPacientes_anual() {
        return pacientes_anual;
    }

    public void setPacientes_anual(Integer pacientes_anual) {
        this.pacientes_anual = pacientes_anual;
    }

    
}
