/**
 * 
 */
package com.org.paymentgateway.service;

import com.org.paymentgateway.vo.PolicyHolderVO;
import com.org.paymentgateway.vo.PremiumResVO;

/**
 * @author BadGateWay
 *
 */
public interface PaymentService {

	public PremiumResVO writePremiumPaymentDetails(PolicyHolderVO policyHolderVO);
}
