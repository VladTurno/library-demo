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
@NamedQuery(name = "findAllEditori", query = "SELECT e FROM Editore e")
public class Editore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@Min(0)
	@Max(2022)
	@NotBlank
	private Integer annoFondazione;
	
	@NotBlank
	private String paese;
	
	@OneToMany(mappedBy = "editore", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Libro> edizioni;
	
	public Editore() {
		
	}
	
	public Editore (String nome, Integer annoFondazione, String paese) {
		this.nome = nome;
		this.annoFondazione = annoFondazione;
		this.paese = paese;
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

	public Integer getAnnoFondazione() {
		return annoFondazione;
	}

	public void setAnnoFondazione(Integer annoFondazione) {
		this.annoFondazione = annoFondazione;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public List<Libro> getEdizioni() {
		return edizioni;
	}

	public void setEdizioni(List<Libro> edizioni) {
		this.edizioni = edizioni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, annoFondazione, edizioni, nome, paese);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editore other = (Editore) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(annoFondazione, other.annoFondazione)
				&& Objects.equals(edizioni, other.edizioni) && Objects.equals(nome, other.nome)
				&& Objects.equals(paese, other.paese);
	}

	@Override
	public String toString() {
		return "Editore [Id=" + Id + ", nome=" + nome + ", annoFondazione=" + annoFondazione + ", paese=" + paese
				+ ", edizioni=" + edizioni + "]";
	}
	
}
