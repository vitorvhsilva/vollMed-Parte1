package med.voll.api.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private String logradouro ;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    private String complemento;

    private String numero;
}
