package br.com.bjbraz;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableRabbit
public class AccountGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountGeneratorApplication.class, args);
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		factory.setContainerCustomizer(container -> /* customize the container */);
		return factory;
	}


}
