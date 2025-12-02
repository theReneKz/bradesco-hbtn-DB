package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação create");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação create");
        }
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação update");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação update");
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação delete");
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Produto deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação delete");
        }
    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto result = null;
        try {
            System.out.println("Iniciando a transação findById");
            em.getTransaction().begin();
            result = em.find(Produto.class, p.getId());
            System.out.println("Produto encontrado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação findById");
        }
        return result;
    }

    public List<Produto> findAll() {

        List<Produto> produtos = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação findAll");
            em.getTransaction().begin();
            Query query = em.createNativeQuery("Select * from Produto", Produto.class);
            produtos = (List<Produto>)query.getResultList();
            System.out.println("Produto encontrado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação findAll");
        }
        return produtos;
    }
}
