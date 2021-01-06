/**
 * 
 */
package com.org.paymentgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.paymentgateway.PaymentFacadeService;
import com.org.paymentgateway.vo.PolicyHolderVO;
import com.org.paymentgateway.vo.PremiumResVO;

/**
 * @author BadGateWay
 *
 */
@RestController
@RequestMapping("")
public class PaymentController {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private PaymentFacadeService paymentFacadeService;
	
	@GetMapping("/test")
	public String test() {
		return "Im from Payment";
	}
	@GetMapping("/from-insurance")
	public String fromInsurance() {
		String str = webClientBuilder.build()
			.get()
			.uri("http://insurance/insurance/test")
			.retrieve()
			.bodyToMono(String.class)
			.block();
		return str;
	}
	
	@PostMapping("premium-payment")
	public PremiumResVO writePremiumPaymentDetails(@RequestBody PolicyHolderVO policyHolderVO) {
		return paymentFacadeService.writePremiumPaymentDetails(policyHolderVO);
	}
	
	
}
