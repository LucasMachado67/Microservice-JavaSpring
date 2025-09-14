package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    //This is the class where we are going to send publications to broker

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")//Default exchange type
    private String routingKey;

    public void publishMessageEmail(User user){
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso");
        emailDto.setText(user.getName() + " seja bem vindo(a)! \nAgradecemos o seu cadastro.");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
