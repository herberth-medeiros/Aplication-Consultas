package HAUW.example.Aplication.domain.domainConsulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    public List<Consulta>findByDataConsulta(LocalDateTime dataConsulta);

}
