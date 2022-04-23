package tests;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteListarClientes {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();
        List<Cliente> listaClientes = clienteDAO.listarCliente();
        entityManager.getTransaction().commit();
        entityManager.close();

        listaClientes.forEach(System.out::println);
    }
}
