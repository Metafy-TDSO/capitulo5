package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entities.Usuario;

public class UsuarioTeste {

    private static void cadastrar(Usuario usuario, EntityManager em) {
	em.persist(usuario);

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

    private static Usuario buscar(int id, EntityManager em) {
	Usuario usuario = em.find(Usuario.class, id);

	if (usuario == null) {
	    System.out.println("Usuario nao encontrado");
	    throw new Error("Usuario nao encontrado");
	}

	System.out.println("Usuario encontrado " + usuario);

	return usuario;
    };

    private static void atualizar(Usuario usuario, EntityManager em) {
	usuario.setNome("Marcos");

	try {
	    em.getTransaction().begin();
	    em.getTransaction().commit();
	    System.out.println(usuario);
	    System.out.println("Atualizado com sucesso");
	} catch (Exception e) {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    };

    public static void remover(Usuario usuario, EntityManager em) {
	em.remove(usuario);

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

	cadastrar(usuario, em);

	Usuario usuarioEncontrado = buscar(usuario.getId(), em);

	atualizar(usuarioEncontrado, em);

	remover(usuarioEncontrado, em);

	buscar(usuario.getId(), em);

	em.close();
	fabrica.close();

    }
}
