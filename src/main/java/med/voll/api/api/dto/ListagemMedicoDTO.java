package med.voll.api.api.dto;

import lombok.Data;
import med.voll.api.domain.utils.Especialidade;

@Data
public class ListagemMedicoDTO {

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

}
