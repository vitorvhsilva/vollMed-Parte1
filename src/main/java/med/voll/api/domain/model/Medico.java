package med.voll.api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.api.dto.AtualizarMedicoDTO;
import med.voll.api.api.dto.EnderecoDTO;
import med.voll.api.domain.utils.Especialidade;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public void atualizarInformacoes(AtualizarMedicoDTO dados) {
        if (dados.getNome() != null) {
            this.nome = dados.getNome();
        }
        if (dados.getTelefone() != null) {
            this.telefone = dados.getTelefone();
        }
        if (dados.getEndereco() != null) {
            this.endereco.atualizarInformacoes(dados.getEndereco());
        }
    }

}


