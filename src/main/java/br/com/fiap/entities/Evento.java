package br.com.fiap.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private int id;

    @Column(name = "ds_nome", nullable = false, length = 72)
    private String nome;

    @Column(name = "ds_descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "vl_avaliacao")
    private int avaliacao;

    @Column(name = "dt_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicio;

    @Column(name = "dt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFim;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_criador", foreignKey = @ForeignKey(name = "fk_evento_criador"), nullable = false)
    private Criador criador;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tbl_usuario_evento", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
	    @JoinColumn(name = "id_evento") }, foreignKey = @ForeignKey(name = "fk_usuario_evento"), inverseForeignKey = @ForeignKey(name = "fk_evento_usuario"))
    private List<Usuario> usuarios;

    public Evento() {

    }

    public Evento(int id, String nome, String descricao, int avaliacao, Calendar dataInicio, Calendar dataFim,
	    Criador criador, List<Usuario> usuarios) {
	super();
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.avaliacao = avaliacao;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
	this.criador = criador;
	this.usuarios = usuarios;
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

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public int getAvaliacao() {
	return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
	this.avaliacao = avaliacao;
    }

    public Calendar getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
	this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
	return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
	this.dataFim = dataFim;
    }

    public Criador getCriador() {
	return criador;
    }

    public void setCriador(Criador criador) {
	this.criador = criador;
    }

    public List<Usuario> getUsuarios() {
	return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + avaliacao;
	result = prime * result + ((criador == null) ? 0 : criador.hashCode());
	result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
	result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + id;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
	Evento other = (Evento) obj;
	if (avaliacao != other.avaliacao)
	    return false;
	if (criador == null) {
	    if (other.criador != null)
		return false;
	} else if (!criador.equals(other.criador))
	    return false;
	if (dataFim == null) {
	    if (other.dataFim != null)
		return false;
	} else if (!dataFim.equals(other.dataFim))
	    return false;
	if (dataInicio == null) {
	    if (other.dataInicio != null)
		return false;
	} else if (!dataInicio.equals(other.dataInicio))
	    return false;
	if (descricao == null) {
	    if (other.descricao != null)
		return false;
	} else if (!descricao.equals(other.descricao))
	    return false;
	if (id != other.id)
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	if (usuarios == null) {
	    if (other.usuarios != null)
		return false;
	} else if (!usuarios.equals(other.usuarios))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", avaliacao=" + avaliacao
		+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", criador=" + criador + ", usuarios="
		+ usuarios + "]";
    }

}
