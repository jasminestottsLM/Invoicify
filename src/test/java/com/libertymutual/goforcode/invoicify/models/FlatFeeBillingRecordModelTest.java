package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class FlatFeeBillingRecordModelTest { 


	@Test
	public void getAmount_returns_amount() {
		double amount = 2;
		
		FlatFeeBillingRecord testBilling = new FlatFeeBillingRecord();
		testBilling.setAmount(amount);

		assertThat(testBilling.getAmount()).isEqualTo(amount);
	}
	 
	@Test
	public void getTotal() {
		double amount = 3;
		
		FlatFeeBillingRecord testBilling = new FlatFeeBillingRecord();
		testBilling.setAmount(amount);
		
		assertThat(testBilling.getTotal()).isEqualTo(amount);
	}
	
    @Test
    public void test_all_gets_and_sets() {
    	BeanTester tester = new BeanTester();
    	Configuration configuration = new ConfigurationBuilder()
    				.ignoreProperty("createdOn")
    				.build();
        tester.testBean(FlatFeeBillingRecord.class, configuration);
    } 

}
