package HAUW.example.Aplication.domain.domainConsulta;


import HAUW.example.Aplication.domain.domainPaciente.Paciente;
import HAUW.example.Aplication.domain.domainMedicos.Medico;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Table(name = "consulta")
@Entity(name= "consulta")

public class Consulta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @Column(unique = true)
    private LocalDateTime dataConsulta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

}
