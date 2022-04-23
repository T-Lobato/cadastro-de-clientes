package dao;

import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        String query = "SELECT * FROM clientes";
        return this.entityManager.createNativeQuery(query, Cliente.class).getResultList();
    }
}