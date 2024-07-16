package med.voll.api.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import med.voll.api.domain.utils.Especialidade;

@Data
public class CadastroMedicoDTO {

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotNull
    private Boolean ativo;

    @NotBlank @Pattern(regexp = "\\d{4,6}")
    private String crm;

    @NotNull
    private Especialidade especialidade;

    @NotNull @Valid
    private EnderecoDTO endereco;
}
