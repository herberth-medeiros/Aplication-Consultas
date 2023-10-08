package HAUW.example.Aplication.domain.domainMedicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String especialidade,
        String crm) {
}
