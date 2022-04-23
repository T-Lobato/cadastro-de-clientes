package tests;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaPorId {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        entityManager.getTransaction().begin();
        Cliente cliente = clienteDAO.buscarPorId(1);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(cliente.getNome() + " " + cliente.getCpf() + " " + cliente.getSexo());
    }
}
