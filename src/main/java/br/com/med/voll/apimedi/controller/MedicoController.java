package br.com.med.voll.apimedi.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.med.voll.apimedi.models.Medico;
import br.com.med.voll.apimedi.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public Medico cadastrarMedico(@RequestBody @Valid Medico dados) {
        // Registra os campos do json
        return repository.save(dados);
    }

    @GetMapping
    public Page<Medico> listarMedicos(Pageable paginacao) {
        // Lista todos os campos
        return repository.findAllByAtivoTrue(paginacao);
    }

    @PutMapping("/{id}")
    public void atualizarMedico(@PathVariable Long id, @RequestBody @Valid Medico medico) throws BadRequestException {
        // Verifica se o id existe
        var medicoId = repository.findById(id).orElseThrow();

        // Verifica os campos que não podem ser alterados
        if (!medicoId.getEmail().equals(medico.getEmail())) {
            throw new BadRequestException("O campo email não pode ser alterado.");
        }

        if (!medicoId.getCrm().equals(medico.getCrm())) {
            throw new BadRequestException("O campo crm não pode ser alterado.");
        }

        if (!medicoId.getEspecialidade().equals(medico.getEspecialidade())) {
            throw new BadRequestException("O campo especialidade não pode ser alterado.");
        }

        medico.setId(id);
        repository.save(medico);        
    }
    
    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable long id) {
        // Instanciar o objeto
        Medico medico = new Medico();
        
        // Verifica se o id existe
        var medicoId = repository.findById(id);

        // Esse método torna o ativo como false
        medico.excluir();
    }
}
