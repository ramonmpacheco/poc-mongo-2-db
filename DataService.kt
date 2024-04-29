import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataService {

    @Autowired
    lateinit var repositoryA: DataRepositoryA

    @Autowired
    lateinit var repositoryB: DataRepositoryB

    fun getData(): List<Data> {
        return try {
            repositoryA.findAll()
        } catch (e: Exception) {
            println("Erro ao conectar ao banco de dados A. Tentando banco de dados B.")
            repositoryB.findAll()
        }
    }
}
