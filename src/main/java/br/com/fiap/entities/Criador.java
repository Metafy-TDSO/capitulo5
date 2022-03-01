package br.com.fiap.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_criador")
public class Criador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_criador")
	private int id;

	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_criador_usuario"), nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToMany(mappedBy = "criador")
	private List<Evento> eventos;

	public Criador() {

	}

	public Criador(int id, Usuario usuario, List<Evento> eventos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.eventos = eventos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
		result = prime * result + id;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criador other = (Criador) obj;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
			return false;
		if (id != other.id)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Criador [id=" + id + ", usuario=" + usuario + ", eventos=" + eventos + "]";
	}

}
