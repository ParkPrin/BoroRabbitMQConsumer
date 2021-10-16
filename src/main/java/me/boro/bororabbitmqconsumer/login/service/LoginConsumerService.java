package me.boro.bororabbitmqconsumer.login.service;

import lombok.extern.slf4j.Slf4j;
import me.boro.bororabbitmqconsumer.login.dto.LoginResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginConsumerService {

	public void dtoPrint(LoginResult loginResult){
		log.info("message.getBody()={}", loginResult.toString());
	}
}
