package br.com.elo7.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PLANALTO")
public class Planalto implements Serializable {
	
	private static final long serialVersionUID = -9087942488184329160L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="LIMITE_X")
	private int limiteX;
	
	@Column(name="LIMITE_Y")
	private int limiteY;
	
	@OneToMany
	private List<Sonda> sondas;
	
	public Planalto() { }
	
	public Planalto(int limiteX, int limiteY) {
		super();
		this.limiteX = limiteX;
		this.limiteY = limiteY;
	}

	public int getLimiteX() {
		return limiteX;
	}

	public int getLimiteY() {
		return limiteY;
	}
	
	public Long getId() {
		return id;
	}
	
	public static Planalto build(String value) {
		if (!value.matches("\\d{2}")) throw new IllegalArgumentException();
		String[] array = value.split("");
		return new Planalto(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Planalto other = (Planalto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
