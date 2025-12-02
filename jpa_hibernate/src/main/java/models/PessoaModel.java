package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {


    public void create (Pessoa p) {
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
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação create");
        }
    }

    public Pessoa findById (Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa result = null;
        try {
            System.out.println("Iniciando a transação findById");
            em.getTransaction().begin();
            result = em.find(Pessoa.class, p.getId());
            System.out.println("Pessoa encontrada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação findById");
        }
        return result;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação findAll");
            em.getTransaction().begin();
            Query query = em.createNativeQuery("Select * from Pessoa", Pessoa.class);
            pessoas = (List<Pessoa>)query.getResultList();
            System.out.println("Pessoa encontrado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação findAll");
        }
        return pessoas;
    }

    public void update (Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação update");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação update");
        }
    }

    public void delete (Pessoa p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Iniciando a transação delete");
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação delete");
        }
    }
}

