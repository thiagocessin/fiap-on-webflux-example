package br.com.domain.fiaponwebflux.config

import br.com.domain.fiaponwebflux.repository.PessoaRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = [PessoaRepository::class])
class MongoConfiguration : AbstractReactiveMongoConfiguration(){

    /*override fun getDatabaseName(): String {
        return "fiaponpessoadb"
    }*/
    override fun getDatabaseName() ="fiaponpessoadb";

    override fun reactiveMongoClient(): MongoClient {
        return mongoClient()
    }
    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory, mongoConverter: MappingMongoConverter): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(mongoClient(),databaseName)
    }

}