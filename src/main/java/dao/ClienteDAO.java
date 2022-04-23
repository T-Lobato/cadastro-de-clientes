package dao;

import model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarCliente(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void removerCliente(Cliente cliente) {
        cliente = this.entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }

    public Cliente buscarPorId(int id){
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> listarCliente() {
        String query = "SELECT c.* FROM clientes c";
        return this.entityManager.createQuery(query, Cliente.class).getResultList();
    }
}