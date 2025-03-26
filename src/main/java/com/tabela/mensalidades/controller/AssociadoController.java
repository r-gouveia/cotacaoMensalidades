package com.tabela.mensalidades.controller;
import com.tabela.mensalidades.dto.AssociadoDTO;
import com.tabela.mensalidades.entity.Associado;
import com.tabela.mensalidades.repository.AssociadoRepository;
import com.tabela.mensalidades.service.AssociadoService;
import com.tabela.mensalidades.service.CpfService;
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

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private CpfService cpfService;

    public AssociadoController(MensalidadeService mensalidadeService, AssociadoRepository associadoRepository, AssociadoService associadoService, CpfService cpfService) {
        this.mensalidadeService = mensalidadeService;
        this.associadoRepository= associadoRepository;
        this.associadoService = associadoService;
        this.cpfService = cpfService;
    }

    @GetMapping("/mensalidade")
    public double mensalidadeCalculada( @RequestParam String cpf){
        return mensalidadeService.calcularMensalidade(cpf);
    }

    @GetMapping("/cota-franquia")
    public double franquiaCalculada (@RequestParam String cpf){
        return mensalidadeService.calcularFranquia(cpf);
    }

    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<AssociadoDTO> atualizarMensalidade(@PathVariable String cpf, @RequestBody AssociadoDTO associadoDTO){
            Associado associado = associadoRepository.findByCpf(cpf);
            associado.setMensalidade(associadoDTO.getMensalidade());
            Associado associadoAtualizado = associadoRepository.save(associado);
            AssociadoDTO associadoAtualizadoDTO = new AssociadoDTO(associadoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(associadoAtualizadoDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AssociadoDTO> cadastrarAssociado(@RequestBody Associado associado){
        if(!cpfService.validarCpf(associado.getCpf())){
            return ResponseEntity.badRequest().body(null);
        }
        Associado associadoSalvo = associadoRepository.save(associado);
        AssociadoDTO associadoDTO = new AssociadoDTO(associadoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoDTO);
    }

    @DeleteMapping("/associado/{cpf}") // delete add recentemente
    public ResponseEntity<Void> deletarAssociado(@PathVariable String cpf){
        boolean removido = associadoService.deletarAssociadoByCpf(cpf);
        if(removido){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build() ;
    }
}
