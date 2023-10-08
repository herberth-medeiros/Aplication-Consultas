package HAUW.example.Aplication.domain.domainMedicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosCadastroMedico(
        @NotBlank
        String nome,

        @NotBlank
        String especialidade,

        @NotNull
        String crm) {
}
