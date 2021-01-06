/**
 * 
 */
package com.org.paymentgateway.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.paymentgateway.common.utils.CommonUtils;
import com.org.paymentgateway.model.PolicyHolder;
import com.org.paymentgateway.model.Premium;
import com.org.paymentgateway.repository.PaymentRepository;
import com.org.paymentgateway.service.PaymentService;
import com.org.paymentgateway.vo.PolicyHolderVO;
import com.org.paymentgateway.vo.PremiumResVO;

/**
 * @author 7000018390
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	public PremiumResVO writePremiumPaymentDetails(PolicyHolderVO policyHolderVO) {
		try {
			PolicyHolder policyHolder = new PolicyHolder();
			policyHolder.setAge(policyHolderVO.getAge());
			policyHolder.setAlcohol(policyHolderVO.getAlcohol());
			policyHolder.setBloodPressure(policyHolderVO.getBloodPressure());
			policyHolder.setBloodSugar(policyHolderVO.getBloodSugar());
			policyHolder.setDailyExcercise(policyHolderVO.getDailyExcercise());
			policyHolder.setDrugs(policyHolderVO.getDrugs());
			policyHolder.setGender(policyHolderVO.getGender());
			policyHolder.setHypertension(policyHolderVO.getHypertension());
			policyHolder.setName(policyHolderVO.getName());
			policyHolder.setOverWeight(policyHolderVO.getOverWeight());
			policyHolder.setSmoking(policyHolderVO.getSmoking());
			List<Premium> premiumList = new ArrayList<>();
			if(null != policyHolderVO.getPremium()) {
				policyHolderVO.getPremium().forEach(premiumVo->{
					Premium premium = new Premium();
					premium.setAmount(premiumVo.getAmount());
					premium.setPaidDate(CommonUtils.convertStringToDate(premiumVo.getPaidDate()));
					premium.setPaymentMode(premiumVo.getPaymentMode());
					premium.setPaymentStatus("success");
					premium.setYear(premiumVo.getYear());
					premiumList.add(premium);
				});
			}
			policyHolder.setPremium(premiumList);
			paymentRepository.save(policyHolder);
			PremiumResVO premiumResVO = new PremiumResVO();
			premiumResVO.setName(policyHolderVO.getName());
			premiumResVO.setPremiumAmount(policyHolderVO.getPremium().get(0).getAmount());
			premiumResVO.setStatus("success");
			return premiumResVO;
		}catch(Exception e) {
			PremiumResVO premiumResVO = new PremiumResVO();
			premiumResVO.setName(policyHolderVO.getName());
			premiumResVO.setPremiumAmount(null);
			premiumResVO.setStatus("failed" + e.getMessage());
			return premiumResVO;
		}
		
		
	}
}
