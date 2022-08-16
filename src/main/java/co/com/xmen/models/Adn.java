package co.com.xmen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "adn", catalog = "xmen")
public class Adn {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idadn;

	@Column(nullable = false, length = 10000)
	public String adn;

	@Column
	public boolean ismutant;

}
