package br.com.bjbraz.listener.bureau;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;

public class ValidacaoBureauSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.toString(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
