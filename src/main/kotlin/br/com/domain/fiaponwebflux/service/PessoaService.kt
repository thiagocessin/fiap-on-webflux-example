package br.com.domain.fiaponwebflux.service

import br.com.domain.fiaponwebflux.model.dto.CreatePessoaDTO
import br.com.domain.fiaponwebflux.model.dto.PessoaDTO
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono// lib reactive

interface PessoaService {

    fun save(createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO>
    fun findAll(): Flux<PessoaDTO>


}