package HAUW.example.Aplication.domain.domainPaciente;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,

        String nome,

        LocalDate dataNascimento,

        String cpf,

        String email) {
}
