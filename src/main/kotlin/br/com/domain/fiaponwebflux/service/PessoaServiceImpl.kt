package br.com.domain.fiaponwebflux.service

import br.com.domain.fiaponwebflux.model.PessoaEntity
import br.com.domain.fiaponwebflux.model.dto.CreatePessoaDTO
import br.com.domain.fiaponwebflux.model.dto.PessoaDTO
import br.com.domain.fiaponwebflux.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(
        val pessoaRepository: PessoaRepository,//substitui o @AutoWired
) : PessoaService {


    /*
     override fun save(createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO> {
        val pessoaEntity: PessoaEntity = PessoaEntity(null, createPessoaDTO.nome)
        val monoPessoaEntity =  pessoaRepository.save(pessoaEntity)

        return monoPessoaEntity.map { PessoaDTO(it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), it.nome) }

    }*/

    override fun save(createPessoaDTO: CreatePessoaDTO) =
            Mono.just(createPessoaDTO)
                    .map { PessoaEntity(nome = it.nome) }
                    .flatMap { pessoaRepository.save(it) }
                        .map {
                            PessoaDTO(it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), it.nome)
                    }



    override fun findAll() = pessoaRepository.findAll()
            .map {
                     PessoaDTO(it.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), it.nome)
                }
}