package br.com.domain.fiaponwebflux.controller

import br.com.domain.fiaponwebflux.model.dto.CreatePessoaDTO
import br.com.domain.fiaponwebflux.service.PessoaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pessoas")
class PessoaController(
        val pessoaService: PessoaService
) {

    @GetMapping
    fun findAll()=pessoaService.findAll()

    @PostMapping
    fun save(@RequestBody createPessoaDTO: CreatePessoaDTO) = pessoaService.save(createPessoaDTO)

}