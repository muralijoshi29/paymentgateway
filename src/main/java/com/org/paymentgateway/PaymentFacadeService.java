/**
 * 
 */
package com.org.paymentgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.paymentgateway.service.PaymentService;
import com.org.paymentgateway.vo.PolicyHolderVO;
import com.org.paymentgateway.vo.PremiumResVO;

/**
 * @author BadGateWay
 *
 */
@Service
public class PaymentFacadeService {
	
	@Autowired
	private PaymentService paymentService;

	public PremiumResVO writePremiumPaymentDetails(PolicyHolderVO policyHolderVO) {
		return paymentService.writePremiumPaymentDetails(policyHolderVO);
	}
}
