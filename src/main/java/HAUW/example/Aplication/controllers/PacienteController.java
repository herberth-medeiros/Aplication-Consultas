package HAUW.example.Aplication.controllers;


import HAUW.example.Aplication.domain.domainPaciente.DadosAtualizarPaciente;
import HAUW.example.Aplication.domain.domainPaciente.DadosCadastroPaciente;
import HAUW.example.Aplication.domain.domainPaciente.Paciente;
import HAUW.example.Aplication.domain.domainPaciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public ResponseEntity all(DadosCadastroPaciente dados){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroPaciente dados){
        var allList = repository.save(new Paciente(dados));
        return new ResponseEntity<>(allList, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosAtualizarPaciente dados){
        var updateList = repository.getReferenceById(dados.id());
        updateList.atualizando(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
