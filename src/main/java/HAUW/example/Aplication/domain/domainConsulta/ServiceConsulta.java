package HAUW.example.Aplication.domain.domainConsulta;

import HAUW.example.Aplication.domain.domainMedicos.Medico;
import HAUW.example.Aplication.domain.domainMedicos.MedicoRepository;
import HAUW.example.Aplication.domain.domainPaciente.Paciente;
import HAUW.example.Aplication.domain.domainPaciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceConsulta {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta agendar(CadastroConsulta dados){
        Paciente paciente =  pacienteRepository.findById(dados.idPaciente()).get();
        Medico medico = medicoRepository.findById(dados.idMedico()).get();
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dados.dataConsulta());

        return consultaRepository.save(consulta);
    }

    public List<Consulta> findByDataConsulta(LocalDateTime dataConsulta){
        return consultaRepository.findByDataConsulta(dataConsulta);
    }

}
