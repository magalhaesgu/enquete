package br.com.cielo.microservice.enquete.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerguntaDTO {
	
	private Long id;
	
	private List<OpcaoDTO> opcao;
	
	private String titulo;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataFim;
	
	private String email;

}
