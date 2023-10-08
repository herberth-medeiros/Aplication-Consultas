package HAUW.example.Aplication.domain.domainPaciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPaciente(

        @NotBlank(message = "Nome Obrigatorio")
        String nome,

        @NotNull(message = "Data de nascimento obrigatorio")
        LocalDate dataNascimento,

        @NotBlank(message = "Cadastro de cpf obrigatorio")
        String cpf,

        @NotNull(message = "Cadastro de email obrigatorio")
        @Email(message = "Cadastro de Email")
        String email) {

}
