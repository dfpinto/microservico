package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String urlWorker;

	public Payment getPayment(Long workedId, Integer days ) {
		Map<String, String> paramsWorker = new HashMap<>();
		paramsWorker.put("id", ""+workedId);
		Worker worker = restTemplate.getForObject(urlWorker + "/workers/{id}", Worker.class, paramsWorker);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
