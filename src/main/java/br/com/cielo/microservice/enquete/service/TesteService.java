package br.com.cielo.microservice.enquete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cielo.microservice.enquete.client.TesteClient;
import br.com.cielo.microservice.enquete.client.TransportadorClient;
import br.com.cielo.microservice.enquete.dto.PerguntaDTO;
import br.com.cielo.microservice.enquete.dto.VoucherDto;

@Service
public class TesteService {
	
	@Autowired
	private TransportadorClient transportadorClient;
	
	@Autowired
	private TesteClient testeClient;
	
	public VoucherDto apenasTeste(VoucherDto voucherDto) {
		VoucherDto voucherDtoRetorno1 = transportadorClient.apenasTeste(voucherDto);
		VoucherDto voucherDtoRetorno2 = testeClient.apenasTeste(voucherDto);
		return voucherDtoRetorno2;
	}
	
	
	public PerguntaDTO realizaEnquete(PerguntaDTO enqueteDTO) {
		PerguntaDTO perguntaDTO = testeClient.realizaPergunta(enqueteDTO);
		return perguntaDTO;
		
	}	
}
