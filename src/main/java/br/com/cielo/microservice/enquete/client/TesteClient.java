package br.com.cielo.microservice.enquete.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cielo.microservice.enquete.dto.PerguntaDTO;
import br.com.cielo.microservice.enquete.dto.VoucherDto;

@FeignClient("enquetePergunta")
public interface TesteClient {
	
	@RequestMapping(path = "uhuuu", method = RequestMethod.POST)
	public VoucherDto apenasTeste(@RequestBody VoucherDto voucherDto);
	
	@RequestMapping(path = "pergunta", method = RequestMethod.POST)
	public PerguntaDTO realizaPergunta(@RequestBody PerguntaDTO enqueteDTO);	

}
