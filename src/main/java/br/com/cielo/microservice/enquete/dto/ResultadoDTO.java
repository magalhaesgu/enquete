package br.com.cielo.microservice.enquete.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoDTO {
	
	public ResultadoDTO() {
	}	
	
	public ResultadoDTO(Long idItemSelecionado, Long totalVotos) {
		this.idItemSelecionado = idItemSelecionado;
		this.totalVotos = totalVotos;
	}

	private Long totalVotos;
	
	private Long idItemSelecionado;

}
