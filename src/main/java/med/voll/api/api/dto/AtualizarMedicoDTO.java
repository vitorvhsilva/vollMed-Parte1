package med.voll.api.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import med.voll.api.domain.utils.Especialidade;

@Data
public class AtualizarMedicoDTO {

    @NotNull
    private Long id;

    private String nome;
    private String telefone;
    private EnderecoDTO endereco;
}
