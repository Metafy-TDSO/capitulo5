package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entities.Criador;
import br.com.fiap.entities.Usuario;

public class CriadorTeste {

    private static void cadastrar(Criador criador, EntityManager em) {
	em.persist(criador);

	try {
	    em.getTransaction().begin();
	    em.getTransaction().commit();
	    System.out.println("Criado com sucesso");
	} catch (Exception e) {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    };

    private static Criador buscar(int id, EntityManager em) {
	Criador criador = em.find(Criador.class, id);
	if (criador == null) {
	    em.close();
	    System.out.println("Criador nao encontrado");
	    throw new Error("Criador nao encontrado");
	}
	System.out.println("Criador encontrado" + criador);
	return criador;
    };

    private static void atualizar(Criador criador, EntityManager em) {
	criador.setAvaliacao(0);

	try {
	    em.getTransaction().begin();
	    em.getTransaction().commit();
	    System.out.println(criador);
	    System.out.println("Atualizado com sucesso");
	} catch (Exception e) {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    };

    private static void remover(Criador criador, EntityManager em) {
	em.remove(criador);

	try {

	    em.getTransaction().begin();
	    em.getTransaction().commit();
	    System.out.println("Removido com sucesso");
	} catch (Exception e) {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    };

    public static void main(String[] args) {
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("metafy");
	EntityManager em = fabrica.createEntityManager();

	Usuario usuario = new Usuario("Enzo", "enzo@gmail.com", new GregorianCalendar(2000, Calendar.FEBRUARY, 20),
		"12345", null, "011951235");

	Criador criador = new Criador(usuario, 5);

	cadastrar(criador, em);

	Criador cr2 = buscar(criador.getId(), em);

	atualizar(cr2, em);

	remover(cr2, em);

	buscar(criador.getId(), em);

	em.close();
	fabrica.close();
    }
}
