package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;

public enum StatusEnum {
	Aguardando(1, "Aguardando"), Em_Atendimento(2, "Em Atendimento"), Atendido(3, "Atendido");
	
	private Integer codigo;
	private String status;
	
	private StatusEnum(Integer codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getStatus() {
		return status;
	}

	@JsonCreator
	public static StatusEnum verificar(Integer valor) {
		for (StatusEnum s : StatusEnum.values()) {
			if(s.getCodigo().equals(valor)) {
				return s;
			}
		}
		throw new EnumException("Status inválido");
	}
	
}