package br.com.bjbraz;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableRabbit
public class AccountGeneratorApplication {

	@Value("${app.rabbit.host}") String host;
	@Value("${app.rabbit.user}") String user;
	@Value("${app.rabbit.password}") String password;
	@Value("${app.rabbit.port}") int port;

	public static void main(String[] args) {
		SpringApplication.run(AccountGeneratorApplication.class, args);
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		// factory.setContainerCustomizer(container);
		return factory;
	}


	private ConnectionFactory connectionFactory() {
		CachingConnectionFactory retorno = new CachingConnectionFactory(host, port);
		retorno.setUsername(user);
		retorno.setPassword(password);
		return retorno;
	}


}
