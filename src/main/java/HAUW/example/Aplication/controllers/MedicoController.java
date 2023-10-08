package HAUW.example.Aplication.controllers;


import HAUW.example.Aplication.domain.domainMedicos.DadosAtualizarMedico;
import HAUW.example.Aplication.domain.domainMedicos.DadosCadastroMedico;
import HAUW.example.Aplication.domain.domainMedicos.Medico;
import HAUW.example.Aplication.domain.domainMedicos.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public ResponseEntity all(DadosCadastroMedico dados){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        var cadastroMedico = repository.save(new Medico(dados));
        return new ResponseEntity<>(cadastroMedico, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosAtualizarMedico dados){
        var updateMedico = repository.getReferenceById(dados.id());
        updateMedico.atualizando(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
