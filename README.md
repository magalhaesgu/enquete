Enquete-API
===============

API da Enquete Load Balancing que realiza o direcionamento para as aplicações
de EnquetePergunta e EnqueteResposta.

Arquitetura
===========

+ Java
+ Spring Boot
+ Spring Cloud Config Client
+ Spring Cloud Netflix OSS Hystrix
+ Spring Cloud Netflix OSS Ribbon
+ Spring Cloud Netflix OSS Eureka
+ Spring Cloud Feign
+ Lombok
+ Twitter4J

Lista para testes no Postman
=============================
{
	"opcao": [
			{
				"descricao": "Brasil"
			},												
			{
				"descricao": "Alemanha"
			},
			{
				"descricao": "França"
			}	
		],
		"titulo": "Quem você acredita que será o campeão da copa do mundo da Fifa de 2018?",
		"dataInicio": "2020-03-03",
		"dataFim": "2020-03-06",
		"email": "seu.email@gmail.com"
}	
