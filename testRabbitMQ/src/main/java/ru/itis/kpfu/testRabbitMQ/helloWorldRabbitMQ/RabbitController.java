package ru.itis.kpfu.testRabbitMQ.helloWorldRabbitMQ;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitController {
    Logger logger = Logger.getLogger(RabbitController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/emit/{key}/{message}")
    @ResponseBody
    String error(@PathVariable("key") String key, @PathVariable("message") String message) {
        System.out.println(key + " " + message);
        logger.info(String.format("Emit '%s' to '%s'",message,key));
        template.convertAndSend(key, message);
        return String.format("Emit '%s' to '%s'",message,key);
    }
    @RequestMapping("/makeOrder")
    @ResponseBody
    String makeOrder() {
        template.convertAndSend("order", "Hellocvjsdvs");
        return "";
    }

}
