package br.com.cielo.microservice.enquete.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cielo.microservice.enquete.dto.ResultadoDTO;
import br.com.cielo.microservice.enquete.dto.VotacaoDTO;

@FeignClient("enqueteResultado")
public interface EnqueteResultadoClient {
	
	@RequestMapping(path = "cadastrarVoto", method = RequestMethod.POST)
	public VotacaoDTO cadastrarVoto(@RequestBody VotacaoDTO resultadoDTO);
	
	@RequestMapping(path = "resultadoVotacao", method = RequestMethod.POST)
	public List<ResultadoDTO> buscarResultadoVotacao(@RequestBody long idPergunta);

}
