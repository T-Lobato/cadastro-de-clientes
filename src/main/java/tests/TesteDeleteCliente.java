package tests;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteDeleteCliente {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();
        Cliente cliente = clienteDAO.buscarPorId(2);
        clienteDAO.removerCliente(cliente);

        clienteDAO.listarCliente().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
