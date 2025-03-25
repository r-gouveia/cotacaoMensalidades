package com.tabela.mensalidades.controller;
import com.tabela.mensalidades.dto.AssociadoDTO;
import com.tabela.mensalidades.entity.Associado;
import com.tabela.mensalidades.repository.AssociadoRepository;
import com.tabela.mensalidades.service.MensalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private MensalidadeService mensalidadeService;

    @Autowired
    private AssociadoRepository associadoRepository;

    public AssociadoController(MensalidadeService mensalidadeService, AssociadoRepository associadoRepository) {
        this.mensalidadeService = mensalidadeService;
        this.associadoRepository= associadoRepository;
    }

    @GetMapping("/mensalidade")
    public double mensalidadeCalculada( @RequestParam String cpf){
        return mensalidadeService.calcularMensalidade(cpf);
    }

    @GetMapping("/cota-franquia")
    public double franquiaCalculada (@RequestParam String cpf){
        return mensalidadeService.calcularFranquia(cpf);
    }

    @PutMapping
    public ResponseEntity<AssociadoDTO> atualizarMensalidade(@PathVariable String cpf, @RequestBody AssociadoDTO associadoDTO){
            Associado associado = associadoRepository.findByCpf(cpf);
            associado.setMensalidade(associadoDTO.getMensalidade());
            Associado associadoAtualizado = associadoRepository.save(associado);
            AssociadoDTO associadoAtualizadoDTO = new AssociadoDTO(associadoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(associadoAtualizadoDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AssociadoDTO> cadastrarAssociado(@RequestBody Associado associado){
        Associado associadoSalvo = associadoRepository.save(associado);
        AssociadoDTO associadoDTO = new AssociadoDTO(associadoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoDTO);
    }
}
