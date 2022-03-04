package br.com.fiap.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;

	@Column(name = "ds_nome", nullable = false, length = 72)
	private String nome;

	@Column(name = "ds_email", nullable = false, length = 255, unique = true)
	private String email;

	@Column(name = "dt_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "dt_criacao")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Column(name = "ds_senha", nullable = false, length = 255)
	private String senha;

	@Column(name = "im_avatar_url", length = 200)
	private String urlImagem;

	@Column(name = "nr_telefone", nullable = false, length = 11)
	private String numeroTelefone;
	
	@OneToOne(mappedBy = "usuario")
	private Criador criador;	

	@ManyToMany(mappedBy = "usuarios")
	private List<Evento> eventos;

	public Usuario() {

	}

	public Usuario(int id, String nome, String email, Calendar dataNascimento, Calendar dataCriacao, String senha,
			String urlImagem, String numeroTelefone, Criador criador, List<Evento> eventos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCriacao = dataCriacao;
		this.senha = senha;
		this.urlImagem = urlImagem;
		this.numeroTelefone = numeroTelefone;
		this.criador = criador;
		this.eventos = eventos;
	}
	
	

	public Usuario(String nome, String email, Calendar dataNascimento, String senha, String urlImagem,
			String numeroTelefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.urlImagem = urlImagem;
		this.numeroTelefone = numeroTelefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Criador getCriador() {
		return criador;
	}

	public void setCriador(Criador criador) {
		this.criador = criador;
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
		result = prime * result + id;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", dataCriacao=" + dataCriacao + ", senha=" + senha + ", urlImagem=" + urlImagem + ", numeroTelefone="
				+ numeroTelefone + ", criador=" + criador + ", eventos=" + eventos + "]";
	}

	
	

}
