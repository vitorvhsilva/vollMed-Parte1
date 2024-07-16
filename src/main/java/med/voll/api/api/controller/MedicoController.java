package med.voll.api.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.api.dto.AtualizarMedicoDTO;
import med.voll.api.api.dto.CadastroMedicoDTO;
import med.voll.api.api.dto.ListagemMedicoDTO;
import med.voll.api.domain.model.Medico;
import med.voll.api.domain.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroMedicoDTO cadastroMedicoInput){
        medicoService.cadastrar(cadastroMedicoInput);
    }

    @GetMapping
    public Page<ListagemMedicoDTO> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return medicoService.listar(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedicoDTO atualizarMedicoDTO) {
        medicoService.atualizar(atualizarMedicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        medicoService.deletar(id);
    }
}
