package br.com.serratec.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Preencha o campo corretamente")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Email(message = "E-mail inválido") 
	@NotBlank(message = "Preencha o campo corretamente")
	private String email;
	

    @Pattern(regexp = "^\\(\\d{2}\\) 9\\d{4}-\\d{4}$", 
    		message = "Preencha o campo de telefone corretamente")
    @Column(nullable = false)
	private String telefone;
	
    @JsonManagedReference
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}
	
}