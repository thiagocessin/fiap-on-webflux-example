package br.com.domain.fiaponwebflux.repository

import br.com.domain.fiaponwebflux.model.PessoaEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository: ReactiveMongoRepository<PessoaEntity, String>