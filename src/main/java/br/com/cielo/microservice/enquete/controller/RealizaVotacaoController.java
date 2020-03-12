package br.com.cielo.microservice.enquete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.enquete.dto.VotacaoDTO;
import br.com.cielo.microservice.enquete.service.RealizaVotacaoService;

@RestController
@RequestMapping("/votarEnquete")
public class RealizaVotacaoController {
	
	@Autowired
	private RealizaVotacaoService realizaVotacaoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void realizaEnquete(@RequestBody VotacaoDTO resultado) {
		VotacaoDTO resultadoDTO = realizaVotacaoService.cadastrarResultado(resultado);
		System.out.println(resultadoDTO);
	}

}
