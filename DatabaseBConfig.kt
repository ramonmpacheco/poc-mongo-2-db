import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@Configuration
@EnableMongoRepositories(basePackages = ["com.example.databaseB.repository"], mongoTemplateRef = "mongoTemplateB")
class DatabaseBConfig : AbstractMongoClientConfiguration() {

    @Value("\${spring.data.mongodb.databaseB.uri}")
    private lateinit var uri: String

    override fun getDatabaseName(): String = "databaseB"

    override fun mongoClient(): com.mongodb.client.MongoClient =
        com.mongodb.client.MongoClients.create(uri)
}
