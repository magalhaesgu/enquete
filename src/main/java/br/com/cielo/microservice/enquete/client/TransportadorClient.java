package br.com.cielo.microservice.enquete.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cielo.microservice.enquete.dto.VoucherDto;

@FeignClient("transportador")
public interface TransportadorClient {
	
	@RequestMapping(path = "blabla", method = RequestMethod.POST)
	public VoucherDto apenasTeste(@RequestBody VoucherDto voucherDto);	

}
