package tests;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteAtualizarClientes {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();
        Cliente cliente = clienteDAO.buscarPorId(2);
        cliente.setNome("Pedro Henrique");
        clienteDAO.atualizarCliente(cliente);

        System.out.println("Cliente atualizado: " + clienteDAO.buscarPorId(2));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
