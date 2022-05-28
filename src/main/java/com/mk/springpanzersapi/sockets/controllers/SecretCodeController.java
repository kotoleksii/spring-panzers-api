package com.mk.springpanzersapi.sockets.controllers;

import com.mk.springpanzersapi.entities.auth.SecretCodeModel;
import com.mk.springpanzersapi.repository.auth.SecretCodeRepository;
import com.mk.springpanzersapi.sockets.classes.AuthTimerResponseMsg;
import com.mk.springpanzersapi.sockets.classes.AuthTimerRequestMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class SecretCodeController {
    @Autowired
    private SimpMessagingTemplate sMTemplate;

    @Autowired
    private SecretCodeRepository secretCodeRepository;

    @MessageMapping("/auth-timer")
    public void authTimer(final AuthTimerRequestMsg request,
                           final Principal principal) throws Exception{

        System.out.println(principal.getName() + " | " +
                request.getEmail() + " | " +
                request.getMinutes() + ":" + request.getSeconds());

        int minutes = request.getMinutes();
        int seconds = request.getSeconds();
        int timeInSec = minutes * 60 + seconds;
        for (int i = 0; i < timeInSec + 1; ++i){
            this.sMTemplate.convertAndSend(
                    "/tanks-client/auth-timer/" + principal.getName(),
                    new AuthTimerResponseMsg(minutes, seconds));
            --seconds;
            if(seconds < 0){
                --minutes;
                seconds = 59;
            }
            Thread.sleep(1000);
        }
        if(this.secretCodeRepository.existsByEmail(request.getEmail())){
            SecretCodeModel sCModel = this.secretCodeRepository.findByEmail(request.getEmail());
            this.secretCodeRepository.delete(sCModel);
            System.out.println("Code has been deleted");
        }
    }
}
