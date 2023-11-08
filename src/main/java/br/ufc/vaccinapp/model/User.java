package br.ufc.vaccinapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Table(name = "users")
@Entity
public class User  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String email;
	private String password;
	private String name;
	private int age;
	private String cpf;
	private String numberCardSUS;
	
	public User(String cpf, String password) {
		super();
		this.cpf = cpf;
		this.password = password;
	}
	
	
	
	
}
