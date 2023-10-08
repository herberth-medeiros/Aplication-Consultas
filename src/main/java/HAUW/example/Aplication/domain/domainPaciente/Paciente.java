package HAUW.example.Aplication.domain.domainPaciente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "paciente")
@Entity(name = "Paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private LocalDate dataNascimento;
    
    @Column(unique = true)
    private String cpf;
    
    @Column(unique = true)
    private String email;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.cpf = dados.cpf();
        this.email = dados.email();
    }

    public void atualizando(DadosAtualizarPaciente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.dataNascimento() != null){
            this.dataNascimento = dados.dataNascimento();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }
}
