package br.com.cielo.microservice.enquete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.enquete.dto.PerguntaDTO;
import br.com.cielo.microservice.enquete.service.TesteService;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private TesteService testeService;	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public void realizaEnquete(@RequestBody VoucherDto voucherDto) {
//		VoucherDto voucherDtoRetorno = testeService.apenasTeste(voucherDto);
//		System.out.println(voucherDtoRetorno);
//	}

	@RequestMapping(method = RequestMethod.POST)
	public void realizaEnquete(@RequestBody PerguntaDTO enqueteDTO) {
		PerguntaDTO perguntaDTO = testeService.realizaEnquete(enqueteDTO);
		System.out.println(perguntaDTO);
	}	
	
	
}
