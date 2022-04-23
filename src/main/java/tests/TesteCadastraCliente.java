package tests;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteCadastraCliente {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        Cliente cliente = new Cliente("josé", "12633821777", "m");

        entityManager.getTransaction().begin();
        clienteDAO.cadastrarCliente(cliente);

        clienteDAO.listarCliente().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}