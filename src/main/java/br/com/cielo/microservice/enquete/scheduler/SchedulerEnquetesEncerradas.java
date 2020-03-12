package br.com.cielo.microservice.enquete.scheduler;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.cielo.microservice.enquete.client.EnquetePerguntaClient;
import br.com.cielo.microservice.enquete.client.EnqueteResultadoClient;
import br.com.cielo.microservice.enquete.dto.PerguntaDTO;
import br.com.cielo.microservice.enquete.dto.ResultadoDTO;
import br.com.cielo.microservice.enquete.util.EmailUtil;
import br.com.cielo.microservice.enquete.util.Twitter4jUtil;

@Component
public class SchedulerEnquetesEncerradas {
	
	@Autowired
	private EnquetePerguntaClient enquetePerguntaClient;
	
	@Autowired
	private EnqueteResultadoClient enqueteResultadoClient;
	
	@Scheduled(cron = "0/10 * * * * *")//executa a cada 10 segundos
	public void AgendamentoEnvioEnquetesEncerradas() {
		List<PerguntaDTO> listaEnquetesEncerradas = buscaEnqueteEncerradas();
		for (PerguntaDTO perguntaDTO : listaEnquetesEncerradas) {
			String conteudo = montarConteudoEmail(perguntaDTO);
			EmailUtil.sendEmail(perguntaDTO.getEmail(),"Resultado Enquete: "+perguntaDTO.getTitulo(), conteudo);
			Twitter4jUtil.publicarStatus(conteudo);
		}
	}

	private String montarConteudoEmail(PerguntaDTO perguntaDTO) {
		int totalVotos = 0;
		StringBuilder builder = new StringBuilder();
		List<ResultadoDTO> listaResultado = buscaListaResultado(perguntaDTO.getId());
		builder.append("Resultado de votação da Enquete\n\n");
		builder.append("Titulo: "+ perguntaDTO.getTitulo()+"\n\n");
		for (ResultadoDTO resultadoDTO : listaResultado) {
			builder.append("Opção selecionada: "+ resultadoDTO.getIdItemSelecionado() + " Total de votos: "+resultadoDTO.getTotalVotos()+"\n");
			totalVotos += resultadoDTO.getTotalVotos();
		}
		builder.append("\nTotal de votos: "+totalVotos);
		return builder.toString();
		
	}
	
	private List<PerguntaDTO> buscaEnqueteEncerradas() {
		LocalDate dataFimEnquete = LocalDate.now();
		return enquetePerguntaClient.buscaEnquetesEncerradas(dataFimEnquete);
	}
	
	private List<ResultadoDTO> buscaListaResultado(long idPergunta){
		return enqueteResultadoClient.buscarResultadoVotacao(idPergunta);
	}
	
}
