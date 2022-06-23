package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workedId, Integer days ) {
		return new Payment("Bob", 200.0, days);
	}
}
