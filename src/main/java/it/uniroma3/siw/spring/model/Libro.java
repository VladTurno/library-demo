package it.uniroma3.siw.spring.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllLibri", query = "SELECT l FROM Libro l")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String titolo;
	
	@NotBlank
	private String trama;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER)
	private Autore autore;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER)
	private Editore editore;

	public Libro() {
		
	}
	
	public Libro(String titolo, String trama, Autore autore, Editore editore) {
		this.titolo = titolo;
		this.trama = trama;
		this.autore = autore;
		this.editore = editore;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Editore getEditore() {
		return editore;
	}

	public void setEditore(Editore editore) {
		this.editore = editore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, autore, editore, titolo, trama);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(autore, other.autore)
				&& Objects.equals(editore, other.editore) && Objects.equals(titolo, other.titolo)
				&& Objects.equals(trama, other.trama);
	}

	@Override
	public String toString() {
		return "Libro [Id=" + Id + ", titolo=" + titolo + ", trama=" + trama + ", autore=" + autore + ", editore="
				+ editore + "]";
	}
	
}
