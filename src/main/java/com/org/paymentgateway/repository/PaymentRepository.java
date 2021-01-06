/**
 * 
 */
package com.org.paymentgateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.paymentgateway.model.PolicyHolder;

/**
 * @author 7000018390
 *
 */
@Repository
public interface PaymentRepository extends MongoRepository<PolicyHolder, String> {

}
