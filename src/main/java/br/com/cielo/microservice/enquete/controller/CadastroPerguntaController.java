package br.com.cielo.microservice.enquete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.enquete.dto.PerguntaDTO;
import br.com.cielo.microservice.enquete.service.CadastroPerguntaService;

@RestController
@RequestMapping("/cadastrarPerguntaEnquete")
public class CadastroPerguntaController {
	
	@Autowired
	private CadastroPerguntaService cadastroPerguntaService;
	
		@RequestMapping(method = RequestMethod.POST)
		public void realizaEnquete(@RequestBody PerguntaDTO enqueteDTO) {
			PerguntaDTO perguntaDTO = cadastroPerguntaService.cadastrarPergunta(enqueteDTO);
			System.out.println(perguntaDTO);
		}
}
