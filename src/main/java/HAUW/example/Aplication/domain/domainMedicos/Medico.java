package HAUW.example.Aplication.domain.domainMedicos;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    @Column(unique = true)
    private String crm;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
    }

    public void atualizando(DadosAtualizarMedico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.especialidade() != null){
            this.especialidade = dados.especialidade();
        }
        if(dados.crm() != null){
            this.crm = dados.crm();
        }
    }
}
