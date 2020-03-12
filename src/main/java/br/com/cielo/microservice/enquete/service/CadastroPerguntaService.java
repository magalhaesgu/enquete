package br.com.cielo.microservice.enquete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.cielo.microservice.enquete.client.EnquetePerguntaClient;
import br.com.cielo.microservice.enquete.dto.PerguntaDTO;

@Service
public class CadastroPerguntaService {
	
	@Autowired
	private DiscoveryClient eurekaClient;
	
	@Autowired
	private EnquetePerguntaClient enquetePerguntaClient;
	
	
	public PerguntaDTO cadastrarPergunta(PerguntaDTO enqueteDTO) {
		listaInstanciasAtivasEureka();
		PerguntaDTO perguntaDTO = enquetePerguntaClient.cadastrarPergunta(enqueteDTO);
		return perguntaDTO;
		
	}

	private void listaInstanciasAtivasEureka() {
		eurekaClient.getInstances("enquetePergunta").stream()
	 	.forEach(enquetePergunta -> {
	 		System.out.println("localhost:"+enquetePergunta.getPort());
	 	});
	}	

}
