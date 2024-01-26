package br.com.bjbraz.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ServiceListener {
    @RabbitListener(containerFactory="myRabbitListenerContainerFactory", queues="myQueue")
    public void process(String msg) {
        // process incoming message
    }
}
