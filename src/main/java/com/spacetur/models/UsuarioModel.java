package com.spacetur.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection= "usuario")
public class UsuarioModel {

	@Id
	private String id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	
	private List<DestinoModel> pacote = new ArrayList<>();

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<DestinoModel> getPacote() {
		return pacote;
	}

	public void setPacote(List<DestinoModel> pacote) {
		this.pacote = pacote;
	}
	
	public void addPacote(DestinoModel destino) {
		this.pacote.add(destino);
	}
}