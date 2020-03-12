package br.com.cielo.microservice.enquete.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cielo.microservice.enquete.dto.PerguntaDTO;

@FeignClient("enquetePergunta")
public interface EnquetePerguntaClient {
	
	@RequestMapping(path = "pergunta", method = RequestMethod.POST)
	public PerguntaDTO cadastrarPergunta(@RequestBody PerguntaDTO enqueteDTO); 
	
	@RequestMapping(path = "enquetesEncerradas", method = RequestMethod.POST)
	public List<PerguntaDTO> buscaEnquetesEncerradas(@RequestBody LocalDate dataFim);

}
