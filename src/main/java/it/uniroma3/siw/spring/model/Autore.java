package it.uniroma3.siw.spring.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllAutori", query = "SELECT a FROM Autore a")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cognome;
	
	@Min(0)
	@Max(2022)
	@NotBlank
	private Integer annoNascita;
	
	@NotBlank
	private String cittaNatale;
	
	@OneToMany(mappedBy = "autore", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Libro> opere;
	
	public Autore() {
		
	}
	
	public Autore(String nome, String cognome, Integer annoNascita, String cittaNatale) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.cittaNatale = cittaNatale;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Integer annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getCittaNatale() {
		return cittaNatale;
	}

	public void setCittaNatale(String cittaNatale) {
		this.cittaNatale = cittaNatale;
	}

	public List<Libro> getOpere() {
		return opere;
	}

	public void setOpere(List<Libro> opere) {
		this.opere = opere;
	}
	
	public String getNomeCompleto() {
		return this.getNome() +" "+ this.getCognome();
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, annoNascita, cittaNatale, cognome, nome, opere);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autore other = (Autore) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(annoNascita, other.annoNascita)
				&& Objects.equals(cittaNatale, other.cittaNatale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(nome, other.nome) && Objects.equals(opere, other.opere);
	}

	@Override
	public String toString() {
		return "Autore [Id=" + Id + ", nome=" + nome + ", cognome=" + cognome + ", annoNascita=" + annoNascita
				+ ", cittaNatale=" + cittaNatale + ", opere=" + opere + "]";
	}
	
}
