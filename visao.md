Para criar um sistema usando o padrão DAO (Data Access Object) junto com as operações CRUD (Create, Read, Update, Delete) no Spring Boot com MySQL, siga os passos abaixo:

Passo 1: Configuração do Projeto Spring Boot
Criar um Novo Projeto Spring Boot
Utilize o Spring Initializr para gerar um novo projeto Spring Boot.
Selecione as dependências:
Spring Web
Spring Data JPA
MySQL Driver
Spring Boot DevTools (opcional, para facilitar o desenvolvimento)
Passo 2: Configuração do Banco de Dados MySQL
Instalar e Configurar o MySQL

Instale o MySQL em seu ambiente de desenvolvimento.
Crie um banco de dados para o projeto, por exemplo: praias_db.
Configurar as Propriedades do Banco de Dados no Spring Boot

No arquivo application.properties ou application.yml, adicione as configurações do MySQL:
properties
Copiar código
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/praias_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Passo 3: Modelagem das Entidades
Criar as Entidades JPA
java
Copiar código
// Praia.java
import javax.persistence.*;

@Entity
public class Praia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private String localizacao;
private boolean poluida;

    // Getters e Setters
}

// Ong.java
import javax.persistence.*;

@Entity
public class Ong {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private String areaAtuacao;

    // Getters e Setters
}
Passo 4: Implementar o Padrão DAO
Criar Interfaces DAO
java
Copiar código
// IPraiaDAO.java
import java.util.List;

public interface IPraiaDAO {
void save(Praia praia);
Praia findById(Long id);
List<Praia> findAll();
void update(Praia praia);
void delete(Long id);
}

// IOngDAO.java
import java.util.List;

public interface IOngDAO {
void save(Ong ong);
Ong findById(Long id);
List<Ong> findAll();
void update(Ong ong);
void delete(Long id);
}
Implementar Classes DAO
java
Copiar código
// PraiaDAO.java
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PraiaDAO implements IPraiaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Praia praia) {
        entityManager.persist(praia);
    }

    @Override
    public Praia findById(Long id) {
        return entityManager.find(Praia.class, id);
    }

    @Override
    public List<Praia> findAll() {
        return entityManager.createQuery("from Praia", Praia.class).getResultList();
    }

    @Override
    public void update(Praia praia) {
        entityManager.merge(praia);
    }

    @Override
    public void delete(Long id) {
        Praia praia = findById(id);
        if (praia != null) {
            entityManager.remove(praia);
        }
    }
}

// OngDAO.java
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OngDAO implements IOngDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Ong ong) {
        entityManager.persist(ong);
    }

    @Override
    public Ong findById(Long id) {
        return entityManager.find(Ong.class, id);
    }

    @Override
    public List<Ong> findAll() {
        return entityManager.createQuery("from Ong", Ong.class).getResultList();
    }

    @Override
    public void update(Ong ong) {
        entityManager.merge(ong);
    }

    @Override
    public void delete(Long id) {
        Ong ong = findById(id);
        if (ong != null) {
            entityManager.remove(ong);
        }
    }
}
Passo 5: Implementar os Serviços
Criar Serviços para Gerenciamento de Dados
java
Copiar código
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// PraiaService.java
@Service
public class PraiaService {
@Autowired
private IPraiaDAO praiaDAO;

    public List<Praia> getAllPraias() {
        return praiaDAO.findAll();
    }

    public Praia getPraiaById(Long id) {
        return praiaDAO.findById(id);
    }

    public void savePraia(Praia praia) {
        praiaDAO.save(praia);
    }

    public void updatePraia(Praia praia) {
        praiaDAO.update(praia);
    }

    public void deletePraia(Long id) {
        praiaDAO.delete(id);
    }

    public void markPraiaAsPoluida(Long id) {
        Praia praia = getPraiaById(id);
        if (praia != null) {
            praia.setPoluida(true);
            praiaDAO.update(praia);
        }
    }
}

// OngService.java
@Service
public class OngService {
@Autowired
private IOngDAO ongDAO;

    public List<Ong> getAllOngs() {
        return ongDAO.findAll();
    }

    public Ong getOngById(Long id) {
        return ongDAO.findById(id);
    }

    public void saveOng(Ong ong) {
        ongDAO.save(ong);
    }

    public void updateOng(Ong ong) {
        ongDAO.update(ong);
    }

    public void deleteOng(Long id) {
        ongDAO.delete(id);
    }
}
Passo 6: Criar os Controladores
Definir Controladores REST
java
Copiar código
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// PraiaController.java
@RestController
@RequestMapping("/praias")
public class PraiaController {
@Autowired
private PraiaService praiaService;

    @GetMapping
    public List<Praia> getAllPraias() {
        return praiaService.getAllPraias();
    }

    @GetMapping("/{id}")
    public Praia getPraiaById(@PathVariable Long id) {
        return praiaService.getPraiaById(id);
    }

    @PostMapping
    public void createPraia(@RequestBody Praia praia) {
        praiaService.savePraia(praia);
    }

    @PutMapping("/{id}")
    public void updatePraia(@PathVariable Long id, @RequestBody Praia praia) {
        praia.setId(id);
        praiaService.updatePraia(praia);
    }

    @DeleteMapping("/{id}")
    public void deletePraia(@PathVariable Long id) {
        praiaService.deletePraia(id);
    }

    @PutMapping("/{id}/poluida")
    public void markPraiaAsPoluida(@PathVariable Long id) {
        praiaService.markPraiaAsPoluida(id);
    }
}

// OngController.java
@RestController
@RequestMapping("/ongs")
public class OngController {
@Autowired
private OngService ongService;

    @GetMapping
    public List<Ong> getAllOngs() {
        return ongService.getAllOngs();
    }

    @GetMapping("/{id}")
    public Ong getOngById(@PathVariable Long id) {
        return ongService.getOngById(id);
    }

    @PostMapping
    public void createOng(@RequestBody Ong ong) {
        ongService.saveOng(ong);
    }

    @PutMapping("/{id}")
    public void updateOng(@PathVariable Long id, @RequestBody Ong ong) {
        ong.setId(id);
        ongService.updateOng(ong);
    }

    @DeleteMapping("/{id}")
    public void deleteOng(@PathVariable Long id) {
        ongService.deleteOng(id);
    }
}
Passo 7: Testar a Aplicação
Executar o Projeto

Execute a aplicação Spring Boot. O projeto deve estar disponível em http://localhost:8080.
Testar Endpoints com Postman ou cURL

Teste os endpoints de GET, POST, PUT e DELETE para verificar se as funcionalidades estão funcionando corretamente.
Passo 8: Documentação e Segurança (Opcional)
Adicionar Documentação com Swagger

Adicione dependências Swagger ao seu projeto para documentar e testar a API via interface web.
Configurar Segurança com Spring Security

Implemente autenticação e autorização para proteger as APIs, caso necessário.
Com esses passos, você terá um backend funcional em Spring Boot com MySQL, utilizando o padrão DAO para as operações CRUD e gerenciamento de informações sobre praias e ONGs.






