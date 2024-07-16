package med.voll.api.domain.service;

import lombok.AllArgsConstructor;
import med.voll.api.api.dto.AtualizarMedicoDTO;
import med.voll.api.api.dto.CadastroMedicoDTO;
import med.voll.api.api.dto.ListagemMedicoDTO;
import med.voll.api.domain.model.Endereco;
import med.voll.api.domain.model.Medico;
import med.voll.api.domain.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    private MedicoRepository medicoRepository;
    private ModelMapper modelMapper;

    public void cadastrar(CadastroMedicoDTO cadastroMedicoInput){
        Medico medico = modelMapper.map(cadastroMedicoInput, Medico.class);
        medico.setEndereco(modelMapper.map(cadastroMedicoInput.getEndereco(), Endereco.class));
        medicoRepository.save(medico);
    }

    public Page<ListagemMedicoDTO> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao)
                .map(m -> modelMapper.map(m, ListagemMedicoDTO.class));
    }

    public void atualizar(AtualizarMedicoDTO atualizarMedicoDTO) {
        Medico medico = medicoRepository.findById(atualizarMedicoDTO.getId()).get();
        medico.atualizarInformacoes(atualizarMedicoDTO);
    }

    public void deletar(Long id) {
        Medico medico = medicoRepository.findById(id).get();
        medico.setAtivo(false);
    }
}
