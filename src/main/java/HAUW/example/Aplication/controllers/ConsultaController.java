package HAUW.example.Aplication.controllers;


import HAUW.example.Aplication.domain.domainConsulta.CadastroConsulta;
import HAUW.example.Aplication.domain.domainConsulta.ConsultaRepository;
import HAUW.example.Aplication.domain.domainConsulta.ServiceConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ServiceConsulta serviceConsulta;

    @Autowired
    private ConsultaRepository repository;

    @GetMapping
    public ResponseEntity all(CadastroConsulta dados) {
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroConsulta dados) {
        var cadastroConsulta = serviceConsulta.agendar(dados);
        return new ResponseEntity<>(cadastroConsulta, HttpStatus.CREATED);
    }
    @GetMapping("/find")
    public ResponseEntity findByDataConsulta(@RequestParam LocalDateTime dataConsulta) {
        return ResponseEntity.ok(serviceConsulta.findByDataConsulta(dataConsulta));
    }

}
