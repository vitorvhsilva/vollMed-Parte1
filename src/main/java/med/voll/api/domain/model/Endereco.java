package med.voll.api.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.api.dto.EnderecoDTO;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro ;

    private String bairro;

    private String cep;

    private String cidade;

    private String uf;

    private String complemento;

    private String numero;

    public void atualizarInformacoes(EnderecoDTO dados) {
        if (dados.getLogradouro() != null) {
            this.logradouro = dados.getLogradouro();
        }
        if (dados.getBairro() != null) {
            this.bairro = dados.getBairro();
        }
        if (dados.getCep() != null) {
            this.cep = dados.getCep();
        }
        if (dados.getUf() != null) {
            this.uf = dados.getUf();
        }
        if (dados.getCidade() != null) {
            this.cidade = dados.getCidade();
        }
        if (dados.getNumero() != null) {
            this.numero = dados.getNumero();
        }
        if (dados.getComplemento() != null) {
            this.complemento = dados.getComplemento();
        }
    }

}
