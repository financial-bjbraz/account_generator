package br.com.bjbraz.listener.account;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RabbitListener(queues = "hello")
public class AccountListener {

    static final String queueName = "spring-boot";

    @Autowired
    private RabbitTemplate template;

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }

}
