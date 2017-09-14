package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class RateBasedBillingRecordTest {

	@Test
	public void getTotal_returns_product() {
		double rate = 2;
		double quantity = 3;

		RateBasedBillingRecord testBilling = new RateBasedBillingRecord();
		testBilling.setRate(2);
		testBilling.setQuantity(3);
		double product = rate * quantity;

		assertThat(testBilling.getTotal()).isEqualTo(product);
	}
	
    @Test
    public void test_all_gets_and_sets() {
    	BeanTester tester = new BeanTester();
    	Configuration configuration = new ConfigurationBuilder()
    				.ignoreProperty("createdOn")
    				.build();
        tester.testBean(RateBasedBillingRecord.class, configuration);
    } 

    @Test
    public void test_CreatedOn_sets_date() {
    	RateBasedBillingRecord testBilling = new RateBasedBillingRecord();
    	Date testDate = new Date();
    	testBilling.setCreatedOn(testDate);
    	
    	assertThat(testBilling.getCreatedOn()).isEqualTo(testDate);
    }
}
