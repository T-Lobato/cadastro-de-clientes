package testes;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteDeleteCliente {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();

        Cliente cliente = clienteDAO.buscarPorId(3);

        clienteDAO.removerCliente(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
