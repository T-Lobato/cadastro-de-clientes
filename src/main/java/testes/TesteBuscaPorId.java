package testes;

import dao.ClienteDAO;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaPorId {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);


        entityManager.getTransaction().begin();

        Cliente cliente = clienteDAO.buscarPorId(2);

        entityManager.getTransaction().commit();
        entityManager.close();

        limpaTela();
        System.out.println(cliente.getNome());



    }

    public static void limpaTela(){
        for(int i = 0; i <= 100; i++){

            System.out.println();

        }
    }

}
