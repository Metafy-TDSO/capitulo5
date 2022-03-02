package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("metafy");
		EntityManager em = fabrica.createEntityManager();

		int opcao;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n1-Usuario \n2-Evento \n3-Sair"));
			int opcao2;

			switch (opcao) {

			case 1:

				do {
					opcao2 = Integer.parseInt(JOptionPane.showInputDialog(
							"Escolha: \n1-Cadastrar \n2-Consultar \n3-Atualizar \n4-Excluir \n5-Sair"));

					switch (opcao2) {
					case 1:

						break;

					case 2:

						break;

					case 3:

						break;
					case 4:

						break;
					case 5:

						System.out.println("Saindo do usuario");						
						break;
					
					default:
						break;
					}

				} while (JOptionPane.showConfirmDialog(null, "Quer continuar no usuario?") == JOptionPane.YES_OPTION);

				break;

			case 2:
				do {

				} while (JOptionPane.showConfirmDialog(null, "Quer continuar no evento?") == JOptionPane.YES_OPTION);

				break;

			case 3:
				System.out.println("Saindo");
				break;

			default:
				break;
			}
			


		} while (JOptionPane.showConfirmDialog(null, "Quer continuar no sistema?") == JOptionPane.YES_OPTION);
	}
}
