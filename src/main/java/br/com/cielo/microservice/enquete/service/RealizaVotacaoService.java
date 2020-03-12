package br.com.cielo.microservice.enquete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.cielo.microservice.enquete.client.EnqueteResultadoClient;
import br.com.cielo.microservice.enquete.dto.VotacaoDTO;

@Service
public class RealizaVotacaoService {
	
	@Autowired
	private DiscoveryClient eurekaClient;
	
	@Autowired
	private EnqueteResultadoClient enqueteResultadoClient;
	
	public VotacaoDTO cadastrarResultado(VotacaoDTO resultado) {
		listaInstanciasAtivasEureka();
		VotacaoDTO resultadoDTO = enqueteResultadoClient.cadastrarVoto(resultado);
		return resultadoDTO;
		
	}
	
	private void listaInstanciasAtivasEureka() {
		eurekaClient.getInstances("enqueteResultado").stream()
	 	.forEach(enquetePergunta -> {
	 		System.out.println("localhost:"+enquetePergunta.getPort());
	 	});
	}	
}
