package HAUW.example.Aplication.domain.domainConsulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CadastroConsulta(

        Long id,


        Long idMedico,


        Long idPaciente,

        @Future
        LocalDateTime dataConsulta
) {
}
